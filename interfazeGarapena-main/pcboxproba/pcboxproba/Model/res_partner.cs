using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pcboxproba.Model
{
    public partial  class res_partner
    {
        [Key]
        public int id { get; set; }
        public bool is_company { get; set; }
        public string name { get; set; }
        public int customer_rank { get; set; }
        public int supplier_rank { get; set; }

    }
}
