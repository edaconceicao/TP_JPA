
// Implémenter ici les fonctions paint à ajouter dans chacune des classes du modèle.

Rectangle.prototype.paint = function(ctx) {
  //TODO Manager color
  ctx.strokeStyle = this.color;
  ctx.lineWidth = this.thickness;
  ctx.rect(this.startX, this.startY, this.width, this.height);
  ctx.stroke();
};

Line.prototype.paint = function(ctx) {
  //TODO Manager color
  ctx.strokeStyle = this.color;
  ctx.lineWidth = this.thickness;
  ctx.beginPath();
  ctx.moveTo(this.startX, this.startY);
  ctx.lineTo(this.endX, this.endY);
  ctx.stroke();
};

Drawing.prototype.paint = function(ctx, canvas) {
  //console.log(this.getForms());
  ctx.fillStyle = '#F0F0F0'; // set canvas' background color
  ctx.fillRect(0, 0, canvas.width, canvas.height);
  this.shapeArray.foreach(element => element.paint(ctx))
};
