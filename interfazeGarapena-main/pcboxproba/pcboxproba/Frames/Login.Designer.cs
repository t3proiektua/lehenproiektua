namespace pcboxproba.Frames
{
    partial class Login
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Login));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.emailtb = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.logina_egiaztatu_btn = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.paswordtb = new System.Windows.Forms.TextBox();
            this.password_visible_btn = new System.Windows.Forms.Button();
            this.helpProvider1 = new System.Windows.Forms.HelpProvider();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImage = global::pcboxproba.Properties.Resources.icon;
            this.pictureBox1.Location = new System.Drawing.Point(171, 31);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(195, 172);
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // emailtb
            // 
            this.helpProvider1.SetHelpString(this.emailtb, "Sartu ezazu odoo-ko erabiltzailea");
            this.emailtb.Location = new System.Drawing.Point(156, 301);
            this.emailtb.Name = "emailtb";
            this.helpProvider1.SetShowHelp(this.emailtb, true);
            this.emailtb.Size = new System.Drawing.Size(207, 20);
            this.emailtb.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.label1.Location = new System.Drawing.Point(153, 275);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(119, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Sartu ezazu zure emaila";
            // 
            // logina_egiaztatu_btn
            // 
            this.logina_egiaztatu_btn.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.logina_egiaztatu_btn.Location = new System.Drawing.Point(191, 435);
            this.logina_egiaztatu_btn.Name = "logina_egiaztatu_btn";
            this.logina_egiaztatu_btn.Size = new System.Drawing.Size(133, 59);
            this.logina_egiaztatu_btn.TabIndex = 3;
            this.logina_egiaztatu_btn.Text = "Hasi saioa";
            this.logina_egiaztatu_btn.UseVisualStyleBackColor = true;
            this.logina_egiaztatu_btn.Click += new System.EventHandler(this.logina_egiaztatu_btn_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(388, 232);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(35, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "label2";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.label3.Location = new System.Drawing.Point(153, 350);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(134, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Sartu ezazu zure pasahitza";
            // 
            // paswordtb
            // 
            this.helpProvider1.SetHelpString(this.paswordtb, "Sartu ezazu odoo-ko pasahitza");
            this.paswordtb.Location = new System.Drawing.Point(156, 383);
            this.paswordtb.Name = "paswordtb";
            this.paswordtb.PasswordChar = '*';
            this.helpProvider1.SetShowHelp(this.paswordtb, true);
            this.paswordtb.Size = new System.Drawing.Size(207, 20);
            this.paswordtb.TabIndex = 6;
            // 
            // password_visible_btn
            // 
            this.password_visible_btn.Location = new System.Drawing.Point(382, 383);
            this.password_visible_btn.Name = "password_visible_btn";
            this.password_visible_btn.Size = new System.Drawing.Size(75, 23);
            this.password_visible_btn.TabIndex = 7;
            this.password_visible_btn.Text = "Erakutsi";
            this.password_visible_btn.UseVisualStyleBackColor = true;
            this.password_visible_btn.Click += new System.EventHandler(this.password_visible_btn_Click);
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(540, 598);
            this.Controls.Add(this.password_visible_btn);
            this.Controls.Add(this.paswordtb);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.logina_egiaztatu_btn);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.emailtb);
            this.Controls.Add(this.pictureBox1);
            this.HelpButton = true;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Login";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Pc Box";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.TextBox emailtb;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button logina_egiaztatu_btn;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        public System.Windows.Forms.TextBox paswordtb;
        private System.Windows.Forms.Button password_visible_btn;
        private System.Windows.Forms.HelpProvider helpProvider1;
    }
}