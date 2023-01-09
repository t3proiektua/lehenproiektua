using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pcboxproba.Model
{
    public partial class purchase_order_line
    {

        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public double product_uom_qty { get; set; }
        public int product_id { get; set; }

    }
}
