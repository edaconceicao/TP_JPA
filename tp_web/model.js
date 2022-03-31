
// Implémenter ici les 4 classes du modèle.
// N'oubliez pas l'héritage !
// Depuis la correction car + simple que ce je propose
function Drawing(){
	this.shapeArray = [];
}

function Shape (startX, startY, thisckness, color){
	this.startX = startX;
	this.startY = startY;
	this.thisckness = thisckness;
	this.color = color;
}

function Rectangle(startX, startY, thisckness, color, height, width){
	Shape.call(this, startX, startY, thisckness, color);
	this.height = height;
	this.width = width;
}

function Line(startX, startY, thisckness, color, endX, endY){
	Shape.call(this, startX, startY, thisckness, color);
	this.endX = endX;
	this.endY = endY;
}