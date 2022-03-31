
// La création d'un Dnd requière un canvas et un interacteur.
// L'interacteur viendra dans un second temps donc ne vous en souciez pas au départ.
function DnD(canvas, interaction) {
	// Définir ici les attributs de la 'classe'
	this.interaction = interaction;
	this.isOn = false;
	this.startX = 0;
	this.startY = 0;
	this.endX = 0;
	this.endY = 0;
	// Developper les 3 fonctions gérant les événements

	this.maFctGerantLaPression = function(evt){
		this.isOn = true;
		var position = getMousePosition(canvas,evt);
		this.startX = position.x
		this.startY = position.y
		this.interaction.onInteractionStart(this);
	}.bind(this);
	
	this.maFctGerantLeDeplacement = function(evt){
		if(this.isOn){
			var position = getMousePosition(canvas,evt);
			this.endX = position.x
			this.endY = position.y
			this.interaction.onInteractionUpdate(this);
		}
	}.bind(this);
	
	this.maFctGerantLeRelachement = function(evt){
		var position = getMousePosition(canvas,evt);
		this.endX = position.x
		this.endY = position.y
		this.isOn = false;	
		this.interaction.onInteractionEnd(this);
	}.bind(this);
	
	
	// Associer les fonctions précédentes aux évènements du canvas.
	canvas.addEventListener('mousedown', this.maFctGerantLaPression, false);
	canvas.addEventListener('mousemove', this.maFctGerantLeDeplacement, false);
	canvas.addEventListener('mouseup', this.maFctGerantLeRelachement, false);
};


// Place le point de l'événement evt relativement à la position du canvas.
function getMousePosition(canvas, evt) {
  var rect = canvas.getBoundingClientRect();
  return {
    x: evt.clientX - rect.left,
    y: evt.clientY - rect.top
  };
};



