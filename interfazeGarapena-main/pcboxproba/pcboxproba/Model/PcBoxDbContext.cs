using pcboxproba.Model.res;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pcboxproba.Model
{
    public class PcBoxDbContext : DbContext
    {
        public PcBoxDbContext() : base(nameOrConnectionString: "PcBoxDBContext")
        { }

        public DbSet<res_partner> res_partners { get; set; }
        public DbSet<res_users> res_users { get; set; }
        public DbSet<sale_order_line> sale_order_lines { get; set; }
        public DbSet<stock_move> stock_moves { get; set; }
        public DbSet<stock_valuation_layer> stock_valuation_layers {get;set;}
        public DbSet<sale_order>sale_orders { get; set; }
        public DbSet<purchase_order_line> purchase_order_lines { get; set; }
        public DbSet<purchase_order> purchase_orders { get; set; }




        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}


