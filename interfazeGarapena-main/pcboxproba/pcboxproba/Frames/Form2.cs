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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (var db = new PcBoxDbContext()) 
            {
                var logindata = db.res_users.Select(b=>b.login).ToArray();
                if (logindata != null)
                {
                    if(emailtb.Text!="")
                    {
                        for(int i=0; i < logindata.Length; i++)
                        {
                            if (emailtb.Text == logindata[i])
                            {
                                
                                Form3 form3 = new Form3();
                                form3.Show();
                                
                                form3.erabiltzailea_target_label.Text= form3.erabiltzailea_target_label.Text+" "+logindata[i];
                                Visible = false;

                            }
                        }
                    }
                }
                

                
            }

            

        }


    }
}
