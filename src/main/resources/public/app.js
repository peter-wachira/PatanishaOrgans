$(document).ready(function(){
// Animations init
new WOW().init();

var typed=new Typed(`#type`,{
     strings:[" Hair Salon Application"," At the very least, they should have be able to add a list of stylists and their clients "],
     backSpeed:70,
     typeSpeed:80,
     smartBackspace:true,
     loop: true,
   })
   var typed =new Typed(`#msg`,{
        strings:[" Your Squad has been saved ! "],
        backSpeed:70,
        typeSpeed:80,
        smartBackspace:true,
      })
})


function secondClick(){
timer:4000
Swal.fire(
  'View Recipients?',
)
}

function firstClick(){
timer:4000
Swal.fire(
  'View Donors?',

)
}

$(document).ready(function() {
$('.mdb-select').materialSelect();
});


// Animations init
new WOW().init();
