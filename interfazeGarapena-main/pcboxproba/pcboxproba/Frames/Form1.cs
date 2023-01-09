using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Entity;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using pcboxproba.Model;

namespace pcboxproba
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            using (var db = new PcBoxDbContext())
            {
                var produktuakData = db.stock_valuation_layers.GroupBy(b=>b.product_id).ToDictionary(x=>x.Key,x=>x.Sum(d=> d.quantity));

                if(produktuakData != null)
                {
                    if(produktuakData.Count() > 0)
                    {
                        chart1.DataSource= produktuakData;
                        chart1.Series[0].YValueMembers = "Value";
                        chart1.Series[0].XValueMember = "Key";
                        chart1.DataBind();
                    }
                }


            }

        }


    }
}
