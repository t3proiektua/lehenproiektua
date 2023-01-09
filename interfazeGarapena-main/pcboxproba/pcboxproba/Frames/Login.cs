using pcboxproba.Model;
using System;
using System.CodeDom;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace pcboxproba.Frames
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        //evento click del boton logina_egiaztatu_btn
        private void logina_egiaztatu_btn_Click(object sender, EventArgs e)
        {
            using (var db = new PcBoxDbContext()) 

            {
                //aray bat sortu odoo-ko erabiltzaile guztiekin
                var login_users_array = db.res_users.Select(b=>b.login).ToArray();
                if (login_users_array != null)
                {
                    if(emailtb.Text!="")
                    {
                        for(int i=0; i < login_users_array.Length; i++)
                        {
                            //array-a eiteratu inputarekin bat etorri arte
                            if (emailtb.Text == login_users_array[i])
                            {
                                //Oodoo-ko password-en arraya deklaratu
                                var login_password_array = db.res_users.Select(b => b.password).ToArray();
                                //odoo-ko pasahitzak has moduan daudenez geure inputa hash-era pasa behar dugu
                                //metodo honek geure pasahitza hashera pasa eta odoko pasahitzarekion konparatuko digu boolean bat itzuliz
                                if (Model.res.GenerateComparableHash.VerifyNonstandardHash(paswordtb.Text, login_password_array[i]))
                                {
                                    //Hurrengo framea deklaratu
                                    Main main = new Main();
                                    main.Show();
                                    main.erabiltzailea_target_label.Text = main.erabiltzailea_target_label.Text + " " + login_users_array[i];
                                    Visible = false;
                                }

                            }
                        }
                    }
                }
                

                
            }

            

        }

        private void password_visible_btn_Click(object sender, EventArgs e)
        {
            if (paswordtb.PasswordChar == '\0')
            {
                paswordtb.PasswordChar = '*';
                password_visible_btn.Text = "Erakutsi";

            }
            else
            {
                paswordtb.PasswordChar = '\0';
                password_visible_btn.Text = "Ezkutatu";
            }

        }
    }
}
