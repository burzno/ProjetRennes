/**
 * 
 */
$(".connect").css("display","none");
$("#utilisateur").css("display","none");

$(document).ready(function() {
	$("#connexion_btn").click(function(){ //lorsqu'on valide le formulaire mise à jour de la page
			//Effacer fenetre de connection
			$("#connexion").css("display","none");
		
			//Affichage de la div utilisateur
			$(".connect").fadeIn();
			
			//Affichage de l'utilisateur connecté
			$("#utilisateur").find("span").text("Bienvenue, "+login.value);
			$("#utilisateur").fadeIn();
			
	});
	$("#menu").find("li").click(function(){
  		if(!$(this).hasClass("dropdown")){
  			$("#menu").find("li").removeClass("active");
      		$(this).addClass("active");
      		$(this).parents("li.dropdown").addClass("active");
      	}
      });	
});
