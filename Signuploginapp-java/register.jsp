<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags-->
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="Colorlib Templates" />
    <meta name="author" content="Colorlib" />
    <meta name="keywords" content="Colorlib Templates" />

    <!-- Title Page-->
    <title>Registration Form</title>

    <!-- Font special for pages-->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
      rel="stylesheet"
    />

    <!-- Main CSS-->
    <link href="css/main.min.css" rel="stylesheet" media="all" />
  </head>

  <body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
      <div class="wrapper wrapper--w790">
        <div class="card card-5">
          <div class="card-heading">
            <h2 class="title" style="color: yellow;">Registration Form</h2>
          </div>
          <div class="card-body" style="background-color: #F8F8FF;">
            <form action="register" method="post">
              <div class="form-row m-b-55">
                <div class="name">Name</div>
                <div class="value">
                  <div class="row row-space">
                    <div class="col-2">
                      <div class="input-group-desc">
                        <input
                          class="input--style-5"
                          type="text"
                          name="fname"
                          required
                        />
                        <label class="label--desc">Muhammad</label>
                      </div>
                    </div>
                    <div class="col-2">
                      <div class="input-group-desc">
                        <input
                          class="input--style-5"
                          type="text"
                          name="lname"
                          required
                        />
                        <label class="label--desc">Ehsaan</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- <div class="form-row">
                            <div class="name">Company</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="company">
                                </div>
                            </div>
                        </div> -->
              <div class="form-row">
                <div class="name">Email</div>
                <div class="value">
                  <div class="input-group">
                    <input
                      class="input--style-5"
                      type="email"
                      name="email"
                      required
                    />
                    <label class="label--desc">demo@website.com</label>
                  </div>
                </div>
              </div>
              <div class="form-row m-b-55">
                <div class="name">Password</div>
                <div class="value">
                  <div class="row row-refine">
                    <div class="col-9">
                      <div class="input-group-desc">
                        <input
                          class="input--style-5"
                          type="text"
                          name="pass"
                          required
                        />
                        <label class="label--desc">ehsaan@537</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="form-row m-b-55">
                <div class="name">Confirm Password</div>
                <div class="value">
                  <div class="row row-refine">
                    <div class="col-9">
                      <div class="input-group-desc">
                        <input
                          class="input--style-5"
                          type="text"
                          name="cpass"
                          required
                        />
                        <label class="label--desc">ehsaan@537</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="form-row m-b-55">
                <div class="name">Type Code</div>
                <div class="value">
                  <div class="row row-refine">
                    <div class="col-9">
                      <div class="input-group-desc">
                        <input
                          class="input--style-5"
                          type="text"
                          name="code"
                          placeholder="Optional For sudents"
                        />
                        <label class="label--desc">Enter your Authcode</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div>
                <button class="btn btn--radius-2 btn--red" type="submit">
                  Register
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Jquery JS-->
    <script
      src="https://code.jquery.com/jquery-3.7.0.js"
      integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
      crossorigin="anonymous"></script>
    <!-- Main JS-->
    <script src="js/global.js"></script>
  </body>
</html>
<!-- end document-->
<!-- This templates was made by Colorlib (https://colorlib.com) -->
