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
    public partial class Form5 : Form
    {

        public Form5()
        {
            InitializeComponent();
        }

        private void Form5_Load(object sender, EventArgs e)
        {

            using ( var db = new PcBoxDbContext())
            {
                var enpresa_id_array = db.res_partners.Where(b=> b.name==label9.Text).Select(b=>b.id).ToArray();
                string enpresa_id_string= enpresa_id_array[0].ToString();
                int enpresa_id_int = Convert.ToInt32(enpresa_id_string);

                var zenbat_erosketa = db.sale_orders.Where(b => b.partner_id == enpresa_id_int).Count().ToString();
                var sortutako_dirua= db.sale_orders.Where(b=> b.partner_id==enpresa_id_int).Sum(b=>b.amount_total).ToString();
                var azken_eskaria_izena = db.sale_orders.Where(b => b.partner_id == enpresa_id_int).OrderBy(b => b.effective_date).Select(b => b.name).ToArray();
                var azken_eskaria_data = db.sale_orders.Where(b => b.partner_id == enpresa_id_int).OrderBy(b => b.effective_date).Select(b => b.effective_date).ToArray();

                eskariak_label.Text = zenbat_erosketa;
                sortutako_dirua_label.Text = sortutako_dirua;
                azken_eskaria_izena_label.Text = azken_eskaria_izena[0];
                azken_eskaria_noiz_label.Text = azken_eskaria_data[0].ToString();






            }
        }

        private void atzera_button_Click(object sender, EventArgs e)
        {
            Form4 form4 = new Form4();
            form4.Show();
            Visible=false;
        }


    }
}
