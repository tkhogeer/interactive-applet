<!DOCTYPE html >
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Assignment 3 Interactive Applet - by Taqwa Khogeer and Maya Bayer</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
<!--custom css -->
<link rel="stylesheet" href="applet-style.css" type="text/css">
</head>
<body>
<div class="container-fluid" style="height:100%;">
  <div class="row"> 
    <!--applet input section-->
    <div class="col-md-3 grey no-padding">
      <table class="table no-border">
        <thead>
          <tr>
            <th><h2>Create your Applet</h2></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><form method="post" action="appletServlet" target="applet">
                <!--shape Style -->
                <h4>Shape Style</h4>
                <h6>Choose a Shape</h6>
                <!--shape type-->
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="shape" id="shape" value="rect" checked>
                  <label class="form-check-label" for="shape"><img src="images/rect.gif" alt="rectangle"></label>
                  <input class="form-check-input" type="radio" name="shape" id="shape" value="roundRect">
                  <label class="form-check-label" for="shape"><img src="images/rnd-rect.gif" alt="rounded rectangle"></label>
                  <input class="form-check-input" type="radio" name="shape" id="shape" value="oval">
                  <label class="form-check-label" for="shape"><img src="images/oval.gif" alt="oval"></label>
                </div>
                <!--shape size--> 
                <br>
                <br>
                <div class="form-row">
                  <div class="form-group col-md-3">
                    <label for="width" >Width</label>
                    <input type="text" class="form-control form-control-sm" id="shapeW" name="shapeW" maxlength="3" value="200">
                  </div>
                  <div class="form-group col-md-3 float-left">
                    <label for="heighth">Height</label>
                    <input type="text" class="form-control form-control-sm" id="shapeH" name="shapeH" maxlength="3" value="150" >
                  </div>
                </div>
                <hr>
                <!-- message -->
                <h4>Message</h4>
                <div class="form-group">
                  <input type="text" class="form-control form-control-sm" id="message" name="message"
                  aria-describedby="message" maxlength="20" value="Write your message">
                  <small id="message" class="form-text text-muted">Your message should not exceed 20 characters long</small> </div>
                <hr>
                <!-- font style -->
                <h4>Font Style</h4>
                <div class="form-row">
                  <div class="form-group col-md-6 ">
                    <label>Font Style</label>
                    <br>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="checkbox" name="fStyle" id="bold" value="bold">
                      <label class="form-check-label" for="bold"><strong>Bold</strong></label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="checkbox" name="fStyle" id="italic" value="italic">
                      <label class="form-check-label" for="italic"><i>Italic</i></label>
                    </div>
                  </div>
                </div>
               
                <div class="form-row">
                  <div class="form-group col-md-4 col-lg-3">
                    <label for="font-size">Font Size</label>
                    <select name="fontSize" id="fontSize" class="custom-select custom-select-sm" >
                      <option value="8">8</option>
                      <option value="10">10</option>
                      <option value="12">12</option>
                      <option value="14" selected="selected">14</option>
                      <option value="18">18</option>
                      <option value="24">24</option>
                      <option value="30">30</option>
                      <option value="36">36</option>
                      <option value="48">48</option>
                      <option value="60">60</option>
                      <option value="72">72</option>
                    </select>
                  </div>
                  <div class="form-group col-md-4">
                    <label for="font-Color">Font Color</label>
                   <select  name="fontColor" id="fontColor" class="custom-select custom-select-sm " >
                      <option  value="black" selected="selected" >Black</option>
                      <option value="white"> White</option>
                      <option value="blue">  Blue</option>
                      <option value="cyan"> Cyan</option>
                      <option value="darkGray"> Dark Gray</option>
                      <option value="gray"> Gray</option>
                      <option value="green"> Green</option>
                      <option value="yellow"> Yellow</option>
                      <option value="lightGray"> Light Gray</option>
                      <option value="magenta"> Magenta</option>
                      <option value="orange"> Orange</option>
                      <option value="pink"> Pink</option>
                      <option value="red"> Red</option>
                      
                    </select>
                  </div>
                </div>
                <hr>
                <!--applet style -->
                <h4>Applet Style</h4>
                <div class="form-row">
                  <div class="form-group col-md-3">
                    <label for="width" >Width</label>
                    <input type="text" class="form-control form-control-sm" name="appW" id="appW" maxlength="3" value="300" >
                  </div>
                  <div class="form-group col-md-3">
                    <label for="heighth">Height</label>
                    <input type="text" class="form-control form-control-sm" name="appH" id="appH" maxlength="3" value="150" >
                  </div>
                  <div class="form-group col-md-6">
                    <label for="background-color">Background Color</label><br>
                    <select name="bgColor" id="bgColor" class="custom-select custom-select-sm" >
                      <option value="black" >Black</option>
                      <option value="white" selected="selected"> White</option>
                      <option value="blue">  Blue</option>
                      <option value="cyan"> Cyan</option>
                      <option value="darkGray"> Dark Gray</option>
                      <option value="gray"> Gray</option>
                      <option value="green"> Green</option>
                      <option value="yellow"> Yellow</option>
                      <option value="lightGray"> Light Gray</option>
                      <option value="magenta"> Magenta</option>
                      <option value="orange"> Orange</option>
                      <option value="pink"> Pink</option>
                      <option value="red"> Red</option>
                    </select>
                  </div>
                </div>
                <hr>
                <div class="alert text-center" role="alert"> verify that all your values are entered <br>before proceeding </div>
                <!--create applet button-->
                <div class="form-group text-center">
                  <input type="submit" class="btn btn-primary" value="Create Your Applet"><br>


                </div>
              </form></td>
          </tr>
        </tbody>
      </table>
    </div >

    
    <div class="col-md-9 text-center fixed-top" >
    <iframe id=iframeDiv name="applet" src="appletServlet"></iframe>
	  </div>
  
    </div>
    </div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
</body>
</html>