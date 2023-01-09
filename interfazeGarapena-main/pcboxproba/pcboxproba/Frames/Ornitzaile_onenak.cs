using pcboxproba.Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace pcboxproba.Frames
{
    public partial class Ornitzaile_onenak : Form
    {
        public Ornitzaile_onenak()
        {
            InitializeComponent();
        }
        public string[] enpresak;
        private void Form8_Load(object sender, EventArgs e)
        {

                using (var db = new PcBoxDbContext())
                {
                    //queriak ornitzaileen array bat itzultzen du onenetik tyxarrenera ordenatuta
                    var mejores_proveedores_array = db.res_partners.Where(b => b.is_company == true && b.id != 1).OrderByDescending(c => c.supplier_rank).Select(b => b.name).ToArray();
                    enpresak = mejores_proveedores_array;
                    if (mejores_proveedores_array != null)
                    {
                        //arrayeko lehenak hornitzaile onenak dira eta horietatik hiru hoberenak labeletam jarriko ditu
                        label1.Text = mejores_proveedores_array[0].ToString();

                        label2.Text = mejores_proveedores_array[1].ToString();

                        label3.Text = mejores_proveedores_array[2].ToString();

                    }


                }
            }

        private void atzera_button_Click(object sender, EventArgs e)
        {
            Main main = new Main();
            main.Show();
            Visible = false;
        }
        //enpresaren informazio ezpezifiko-ra eramateko botoiak
        private void button1_Click(object sender, EventArgs e)
        {
            Ornitzaile_ezpezifiko ornitzaile_espezifiko = new Ornitzaile_ezpezifiko();
            ornitzaile_espezifiko.label9.Text = enpresak[0].ToString();
            ornitzaile_espezifiko.Text=enpresak[0].ToString();
            ornitzaile_espezifiko.Show();
            Visible = false;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Ornitzaile_ezpezifiko ornitzaile_espezifiko = new Ornitzaile_ezpezifiko();
            ornitzaile_espezifiko.label9.Text = enpresak[1].ToString();
            ornitzaile_espezifiko.Text = enpresak[1].ToString();
            ornitzaile_espezifiko.Show();
            Visible = false;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Ornitzaile_ezpezifiko ornitzaile_espezifiko = new Ornitzaile_ezpezifiko();
            ornitzaile_espezifiko.label9.Text = enpresak[2].ToString();
            ornitzaile_espezifiko.Text = enpresak[2].ToString();
            ornitzaile_espezifiko.Show();
            Visible = false;
        }
    }
}
