using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pcboxproba.Model
{
    public partial class sale_order
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public int amount_total { get; set; }
        public DateTime effective_date { get; set; }
        public int partner_id { get; set; }

    }
}
