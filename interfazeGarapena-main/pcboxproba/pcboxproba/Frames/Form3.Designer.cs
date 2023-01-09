namespace pcboxproba.Frames
{
    partial class Form3
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form3));
            this.erabiltzailea_target_label = new System.Windows.Forms.Label();
            this.saioa_itxi = new System.Windows.Forms.Button();
            this.bezero_onenak = new System.Windows.Forms.Button();
            this.gehien_saldutako_produktuak = new System.Windows.Forms.Button();
            this.Geien_erositako_produktuak = new System.Windows.Forms.Button();
            this.Hornitzaile_erabilienak = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // erabiltzailea_target_label
            // 
            this.erabiltzailea_target_label.AutoSize = true;
            this.erabiltzailea_target_label.BackColor = System.Drawing.Color.Transparent;
            this.erabiltzailea_target_label.Font = new System.Drawing.Font("Tahoma", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.erabiltzailea_target_label.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.erabiltzailea_target_label.Location = new System.Drawing.Point(301, 21);
            this.erabiltzailea_target_label.Name = "erabiltzailea_target_label";
            this.erabiltzailea_target_label.Size = new System.Drawing.Size(0, 25);
            this.erabiltzailea_target_label.TabIndex = 0;
            this.erabiltzailea_target_label.Click += new System.EventHandler(this.label1_Click);
            // 
            // saioa_itxi
            // 
            this.saioa_itxi.BackColor = System.Drawing.Color.Red;
            this.saioa_itxi.Location = new System.Drawing.Point(430, 82);
            this.saioa_itxi.Name = "saioa_itxi";
            this.saioa_itxi.Size = new System.Drawing.Size(93, 24);
            this.saioa_itxi.TabIndex = 1;
            this.saioa_itxi.Text = "Saioa amaitu";
            this.saioa_itxi.UseVisualStyleBackColor = false;
            this.saioa_itxi.Click += new System.EventHandler(this.button1_Click);
            // 
            // bezero_onenak
            // 
            this.bezero_onenak.Location = new System.Drawing.Point(34, 187);
            this.bezero_onenak.Name = "bezero_onenak";
            this.bezero_onenak.Size = new System.Drawing.Size(127, 38);
            this.bezero_onenak.TabIndex = 2;
            this.bezero_onenak.Text = "Bezero onenak";
            this.bezero_onenak.UseVisualStyleBackColor = true;
            this.bezero_onenak.Click += new System.EventHandler(this.button2_Click);
            // 
            // gehien_saldutako_produktuak
            // 
            this.gehien_saldutako_produktuak.Location = new System.Drawing.Point(365, 187);
            this.gehien_saldutako_produktuak.Name = "gehien_saldutako_produktuak";
            this.gehien_saldutako_produktuak.Size = new System.Drawing.Size(127, 38);
            this.gehien_saldutako_produktuak.TabIndex = 3;
            this.gehien_saldutako_produktuak.Text = "Gehien saldutako produktuak";
            this.gehien_saldutako_produktuak.UseVisualStyleBackColor = true;
            this.gehien_saldutako_produktuak.Click += new System.EventHandler(this.button3_Click);
            // 
            // Geien_erositako_produktuak
            // 
            this.Geien_erositako_produktuak.Location = new System.Drawing.Point(365, 380);
            this.Geien_erositako_produktuak.Name = "Geien_erositako_produktuak";
            this.Geien_erositako_produktuak.Size = new System.Drawing.Size(127, 38);
            this.Geien_erositako_produktuak.TabIndex = 4;
            this.Geien_erositako_produktuak.Text = "Gehien erositako produktuak";
            this.Geien_erositako_produktuak.UseVisualStyleBackColor = true;
            // 
            // Hornitzaile_erabilienak
            // 
            this.Hornitzaile_erabilienak.Location = new System.Drawing.Point(34, 380);
            this.Hornitzaile_erabilienak.Name = "Hornitzaile_erabilienak";
            this.Hornitzaile_erabilienak.Size = new System.Drawing.Size(127, 38);
            this.Hornitzaile_erabilienak.TabIndex = 5;
            this.Hornitzaile_erabilienak.Text = "Hornitzaile erabilienak";
            this.Hornitzaile_erabilienak.UseVisualStyleBackColor = true;
            this.Hornitzaile_erabilienak.Click += new System.EventHandler(this.button5_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImage = global::pcboxproba.Properties.Resources.icon;
            this.pictureBox1.Location = new System.Drawing.Point(-1, -1);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(195, 172);
            this.pictureBox1.TabIndex = 6;
            this.pictureBox1.TabStop = false;
            // 
            // Form3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(550, 578);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.Hornitzaile_erabilienak);
            this.Controls.Add(this.Geien_erositako_produktuak);
            this.Controls.Add(this.gehien_saldutako_produktuak);
            this.Controls.Add(this.bezero_onenak);
            this.Controls.Add(this.saioa_itxi);
            this.Controls.Add(this.erabiltzailea_target_label);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form3";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form3";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        public System.Windows.Forms.Label erabiltzailea_target_label;
        private System.Windows.Forms.Button saioa_itxi;
        private System.Windows.Forms.Button bezero_onenak;
        private System.Windows.Forms.Button gehien_saldutako_produktuak;
        private System.Windows.Forms.Button Geien_erositako_produktuak;
        private System.Windows.Forms.Button Hornitzaile_erabilienak;
        private System.Windows.Forms.PictureBox pictureBox1;
    }
}