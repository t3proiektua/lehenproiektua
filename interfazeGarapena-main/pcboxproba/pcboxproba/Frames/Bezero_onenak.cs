using pcboxproba.Model;
using System;
using System.Data;
using System.Linq;
using System.Windows.Forms;


namespace pcboxproba.Frames
{
    public partial class Bezero_onenak : Form
    {


        public  string[] enpresak;
        public Bezero_onenak()
        {
            InitializeComponent();
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            using(var db = new PcBoxDbContext())
            {

               var  mejores_clientes_array = db.res_partners.Where(b=>b.is_company==true && b.id!=1).OrderByDescending(c=>c.customer_rank).Select(b=>b.name).ToArray();
                enpresak = mejores_clientes_array;
                if( mejores_clientes_array != null)
                {

                    label1.Text = mejores_clientes_array[0].ToString();

                    label2.Text = mejores_clientes_array[1].ToString();

                    label3.Text = mejores_clientes_array[2].ToString();

                }

                
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Bezero_ezpezifiko bezero_ezpezifiko = new Bezero_ezpezifiko();
            bezero_ezpezifiko.label9.Text = enpresak[0].ToString();
            bezero_ezpezifiko.Text = enpresak[0].ToString();
            bezero_ezpezifiko.Show();
            Visible = false;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Bezero_ezpezifiko bezero_ezpezifiko = new Bezero_ezpezifiko();
            bezero_ezpezifiko.label9.Text = enpresak[1].ToString();
            bezero_ezpezifiko.Text = enpresak[1].ToString();
            bezero_ezpezifiko.Show();
            Visible = false;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Bezero_ezpezifiko bezero_ezpezifiko = new Bezero_ezpezifiko();
            bezero_ezpezifiko.label9.Text = enpresak[2].ToString();
            bezero_ezpezifiko.Text = enpresak[2].ToString();
            bezero_ezpezifiko.Show();
            Visible = false;
        }

        private void atzera_button_Click(object sender, EventArgs e)
        {
            Main main = new Main();
            main.Show();
            Visible=false;
        }
    }
}
