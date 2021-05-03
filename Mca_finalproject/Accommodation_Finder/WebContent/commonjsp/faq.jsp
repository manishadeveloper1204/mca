<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FAQ</title>
<style>
.accordion {
  background-color: powderblue;
  color: #444;
  cursor: pointer;
  padding: 18px; 
  text-shadow:green;
  width: 50%;
  border: none;
  text-align:left;
 margin-left:100px;
 /* margin-right:50px; */
 margin-top:50px;
  outline: none;
  font-size: 15px;
  font-weight:bolder;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #ccc; 
  
}

.panel {
  /* padding: 0 4px; */
  display: none;
  margin-left:100px;
  background-color: white;
  width: 50%;
  
  /* overflow: hidden; */
}
</style>
</head>
<body>
<!-- <h2 >Accordion</h2> -->


<div
		style="width: 50%; height: 50px;; background-color:white ; float: left ;margin-bottom: 5px; margin-left: 100px">
		<i class="fa fa-home fa-3x" style="color:white" aria-hidden="true"></i>
		<span
			style="margin-left: 200px; text-decoration: underline; color: green; font-size:large;font-weight:bolder;text-transform:  capitalize;">
			Frequently Asked Question</span>
	</div>




<button class="accordion" style="color:red;">Is it necessary to do registration to contact with the owner?</button>
<div class="panel">
  <p>Yes</p>
</div>

<button class="accordion">Can I find Hostel or PG both here?</button>
<div class="panel">
  <p>Yes you can find both.</p>
</div>

<button class="accordion">Can I search area-wise hostel/PG?</button>
<div class="panel">
  <p>Yes you can search.</p>
</div>

<button class="accordion">Types of owner available?</button>
<div class="panel">
  <p>Here Hostel and Pg owner both are available.  </p>
</div>

<button class="accordion">How this portal is benificial?</button>
<div class="panel">
  <p>This portal is benificial because you can find both hostel owner and pg owner at the same plateform and you can easily search  and contact .</p>
</div>

<button class="accordion">Can I search area-wise hostel/PG?</button>
<div class="panel">
  <p>Yes you can search.</p>
</div>

<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>







</body>
</html>