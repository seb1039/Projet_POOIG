package interfaceGraphique;

public class Palette {


		public Vue vue;
		public Modele model;

		public Palette() {
			this.vue = new Vue();
			this.model = new Modele(vue);
			vue.setVisible(true);
		}

		public Vue getVue() {
			return vue;
		}

		public void setVue(Vue vue) {
			this.vue = vue;
		}

		public Modele getModel() {
			return model;
		}

		public void setModel(Modele model) {
			this.model = model;
		}

		
}
