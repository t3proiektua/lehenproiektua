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
    public partial class Produktu_erosienak : Form
    {
        public Produktu_erosienak()
        {
            InitializeComponent();
        }

        private void Produktu_erosienak_Load(object sender, EventArgs e)
        {
            using (var db = new PcBoxDbContext())
            {
                //bost produktu erosienak itzuliko ditu queryak dictionary formatuan
                var purchase_data_dictionary = db.purchase_order_lines
                .Include("res_partner")
                .GroupBy(x => x.name)
                .OrderByDescending(x => x.Sum(b => b.product_uom_qty))
                .Take(5)
                .ToDictionary(g => g.Key, g => g.Sum(b => b.product_uom_qty));


                if (purchase_data_dictionary != null)
                {
                    if (purchase_data_dictionary.Count > 0)
                    {
                        //User controla Chart motakoa dela ezarri
                        var grafikoa = grafikoaren_kontrola1.Controls
                        .OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var grafiko in grafikoa)
                        {
                            //izenburua jarri
                            grafiko.Titles[0].Text = "Gehien erositako produktuak";
                            //datuak nondik atera jarri
                            grafiko.DataSource = purchase_data_dictionary;
                            //ardatz bakoitzean zer datuk joan behar duten 
                            grafiko.Series[0].YValueMembers = "Value";
                            grafiko.Series[0].XValueMember = "Key";
                            grafiko.DataBind();
                        }
                    }
                }
            }
        }

        //grafikoa 
        private void grafikoa_deskargatu_btn_Click(object sender, EventArgs e)
        {
            var grafikoa_gorde = grafikoaren_kontrola1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
            foreach (var grafiko in grafikoa_gorde)
            {
                grafiko.SaveImage("C:\\Users\\" + Environment.UserName + "\\Desktop\\grafikoak\\produktu_erosienak_grafikoa.png", ChartImageFormat.Png);
               // grafiko.SaveImage("C:\\Users\\" + Environment.UserName + "\\Desktop\\grafikoak\\erregistroa\\produktu_erosienak_grafikoa("+DateTime.Now.ToString()+").png", ChartImageFormat.Png);
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
