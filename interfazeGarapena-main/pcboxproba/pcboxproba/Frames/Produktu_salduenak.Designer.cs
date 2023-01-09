namespace pcboxproba.Frames
{
    partial class Produktu_salduenak
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Produktu_salduenak));
            this.grafikoa_deskargatu_btn = new System.Windows.Forms.Button();
            this.atzera_btn = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.grafikoaren_kontrola1 = new grafikoaDll.Grafikoaren_kontrola();
            this.helpProvider1 = new System.Windows.Forms.HelpProvider();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // grafikoa_deskargatu_btn
            // 
            this.helpProvider1.SetHelpString(this.grafikoa_deskargatu_btn, "Botoi hau sakatzean mahaigaineko \"grafikoak\" karpetan gordeko da");
            this.grafikoa_deskargatu_btn.Location = new System.Drawing.Point(812, 177);
            this.grafikoa_deskargatu_btn.Name = "grafikoa_deskargatu_btn";
            this.helpProvider1.SetShowHelp(this.grafikoa_deskargatu_btn, true);
            this.grafikoa_deskargatu_btn.Size = new System.Drawing.Size(75, 23);
            this.grafikoa_deskargatu_btn.TabIndex = 1;
            this.grafikoa_deskargatu_btn.Text = "Deskargatu";
            this.grafikoa_deskargatu_btn.UseVisualStyleBackColor = true;
            this.grafikoa_deskargatu_btn.Click += new System.EventHandler(this.grafikoa_deskargatu_btn_Click);
            // 
            // atzera_btn
            // 
            this.atzera_btn.Location = new System.Drawing.Point(812, 285);
            this.atzera_btn.Name = "atzera_btn";
            this.atzera_btn.Size = new System.Drawing.Size(75, 23);
            this.atzera_btn.TabIndex = 4;
            this.atzera_btn.Text = "Atzera";
            this.atzera_btn.UseVisualStyleBackColor = true;
            this.atzera_btn.Click += new System.EventHandler(this.atzera_btn_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImage = global::pcboxproba.Properties.Resources.icon;
            this.pictureBox1.Location = new System.Drawing.Point(-1, 0);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(195, 172);
            this.pictureBox1.TabIndex = 7;
            this.pictureBox1.TabStop = false;
            // 
            // grafikoaren_kontrola1
            // 
            this.grafikoaren_kontrola1.Location = new System.Drawing.Point(159, 134);
            this.grafikoaren_kontrola1.Name = "grafikoaren_kontrola1";
            this.grafikoaren_kontrola1.Size = new System.Drawing.Size(606, 374);
            this.grafikoaren_kontrola1.TabIndex = 10;
            // 
            // Produktu_salduenak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(988, 563);
            this.Controls.Add(this.grafikoaren_kontrola1);
            this.Controls.Add(this.atzera_btn);
            this.Controls.Add(this.grafikoa_deskargatu_btn);
            this.Controls.Add(this.pictureBox1);
            this.HelpButton = true;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Produktu_salduenak";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Produktu salduenak";
            this.Load += new System.EventHandler(this.Form6_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button grafikoa_deskargatu_btn;
        private System.Windows.Forms.Button atzera_btn;
        private System.Windows.Forms.PictureBox pictureBox1;
        private grafikoaDll.Grafikoaren_kontrola grafikoaren_kontrola1;
        private System.Windows.Forms.HelpProvider helpProvider1;
    }
}