﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pcboxproba.Model
{
    public partial class res_users
    {
        [Key]
        public int id { get; set; }
        public string login { get; set; }
        public string password { get; set; }
    }
}
