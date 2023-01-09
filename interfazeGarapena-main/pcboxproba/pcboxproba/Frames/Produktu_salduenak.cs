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
using System.Windows.Forms.DataVisualization.Charting;

namespace pcboxproba.Frames
{
    public partial class Produktu_salduenak : Form
    {
        public Produktu_salduenak()
        {
            InitializeComponent();
        }




        private void grafikoaren_kontrola1_Load(object sender, EventArgs e)
        {

        }

        private void Form6_Load(object sender, EventArgs e)
        {
            using (var db = new PcBoxDbContext())
            {
                var sale_data_dictionary = db.sale_order_lines
                .Include("res_partner")
                .GroupBy(x => x.name)
                .OrderByDescending(x => x.Sum(b => b.product_uom_qty))
                .Take(5)
                .ToDictionary(g => g.Key, g => g.Sum(b => b.product_uom_qty));


                if (sale_data_dictionary != null)
                {
                    if (sale_data_dictionary.Count > 0)
                    {
                        var grafikoa = grafikoaren_kontrola1.Controls 
                        .OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var grafiko in grafikoa)
                        {
                            grafiko.Titles[0].Text ="Gehien saldutako produktuak";
                            grafiko.DataSource = sale_data_dictionary;
                            grafiko.Series[0].YValueMembers = "Value";
                            grafiko.Series[0].XValueMember = "Key";
                            grafiko.DataBind();
                        }
                    }
                }
            }

        }

        private void grafikoa_deskargatu_btn_Click(object sender, EventArgs e)
        {
            var grafikoa_gorde = grafikoaren_kontrola1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
            foreach (var grafiko in grafikoa_gorde)
            {
                grafiko.SaveImage("C:\\Users\\"+ Environment.UserName+"\\Desktop\\grafikoak\\produktu_salduenak_grafikoa.png", ChartImageFormat.Png);
               // grafiko.SaveImage("C:\\Users\\" + Environment.UserName + "\\Desktop\\grafikoak\\erregistroa\\produktu_salduenak_grafikoa("+DateTime.Now.ToString()+").png", ChartImageFormat.Png);
            }
        }

        private void atzera_btn_Click(object sender, EventArgs e)
        {
            Main main = new Main();
            main.Show();
            Visible = false;

        }
    }
}
