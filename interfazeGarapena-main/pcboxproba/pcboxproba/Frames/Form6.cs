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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void grafikoaren_kontrola1_Load(object sender, EventArgs e)
        {
            using (var db = new PcBoxDbContext())
            {
                
                var gehien_saldutako_produktuak = db.sale_order_lines.GroupBy(b=>b.product_id).OrderByDescending(b=>b.Sum(a=>a.product_uom_qty)).Take(5).ToDictionary(g=>g.GroupBy(a=>a.name).ToList(),b=>b.Sum(a=>a.product_uom_qty));
                if (gehien_saldutako_produktuak != null)
                {

                        var kontrolak = grafikoaren_kontrola1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        
                    foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "Gehien saldu diren produktuak";
                            kontrola.DataSource = gehien_saldutako_produktuak;

                             kontrola.Series[0].XValueMember = "Key";
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.DataBind();
                        }
                    

                }
            }
        }
    }
}
