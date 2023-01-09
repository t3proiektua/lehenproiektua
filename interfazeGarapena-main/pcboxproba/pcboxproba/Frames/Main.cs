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
    public partial class Main : Form
    {
        public Main()
        {
            InitializeComponent();
        }

        //beheko dena interfazean nabegatzeko botoiak dira,hau da, frame batetik bestera pasatzeko metodoak

        private void saioa_itxi_btn_Click(object sender, EventArgs e)
        {
            Login login = new Login();
            login.Show();
            Visible =false;
        }

        private void bezero_onenak_btn_Click(object sender, EventArgs e)
        {
            Bezero_onenak bezero_onenak = new Bezero_onenak();
            bezero_onenak.Show();
            Visible = false;

        }

        private void gehien_saldutako_produktuak_btn_Click(object sender, EventArgs e)
        {
            Produktu_salduenak produktu_salduenak = new Produktu_salduenak();
            produktu_salduenak.Show();
            Visible=false;
        }

        private void ornitzaile_erabilienak_btn_Click(object sender, EventArgs e)
        {
            Ornitzaile_onenak ornitzaile_onenak = new Ornitzaile_onenak();
            ornitzaile_onenak.Show();
            Visible=false;
        }

        private void Geien_erositako_produktuak_btn_Click(object sender, EventArgs e)
        {
            Produktu_erosienak produktu_Erosienak = new Produktu_erosienak();
            produktu_Erosienak.Show();
            Visible = false;
        }

        private void Main_Load(object sender, EventArgs e)
        {

        }
    }
}
