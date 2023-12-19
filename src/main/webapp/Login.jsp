<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link rel="preconnect" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"> -->
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->



</head>
<style>
    body {
        margin: 0;
        padding: 0;
        background: url(https://i.ibb.co/VQmtgjh/6845078.png) no-repeat;
        height: 100vh;
        font-family: sans-serif;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        overflow: hidden
    }

    @media screen and (max-width: 600px; ) {
        body {
            background-size: cover;
            : fixed
        }
    }

    #particles-js {
        height: 100%
    }

    .loginBox {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 350px;
        min-height: 200px;
        background: #000000;
        border-radius: 10px;
        padding: 40px;
        box-sizing: border-box
    }

    .user {
        margin: 0 auto;
        display: block;
        margin-bottom: 20px
    }

    h3 {
        margin: 0;
        padding: 0 0 20px;
        color: #59238F;
        text-align: center
    }

    .loginBox input {
        width: 100%;
        margin-bottom: 20px
    }

    .loginBox input[type="text"],
    .loginBox input[type="password"] {
        border: none;
        border-bottom: 2px solid #262626;
        outline: none;
        height: 40px;
        color: #fff;
        background: transparent;
        font-size: 16px;
        padding-left: 20px;
        box-sizing: border-box
    }

    .loginBox input[type="text"]:hover,
    .loginBox input[type="password"]:hover {
        color: #42F3FA;
        border: 1px solid #42F3FA;
        box-shadow: 0 0 5px rgba(0, 255, 0, .3), 0 0 10px rgba(0, 255, 0, .2), 0 0 15px rgba(0, 255, 0, .1), 0 2px 0 black
    }

    .loginBox input[type="text"]:focus,
    .loginBox input[type="password"]:focus {
        border-bottom: 2px solid #42F3FA
    }

    .inputBox {
        position: relative
    }

    .inputBox span {
        position: absolute;
        top: 10px;
        color: #262626
    }

    .loginBox input[type="submit"] {
        border: none;
        outline: none;
        height: 40px;
        font-size: 16px;
        background: #59238F;
        color: #fff;
        border-radius: 20px;
        cursor: pointer
    }

    .loginBox a {
        color: #262626;
        font-size: 14px;
        font-weight: bold;
        text-decoration: none;
        text-align: center;
        display: block
    }

    a:hover {
        color: #00ffff
    }

    p {
        color: #0000ff
    }
</style>

<body>
    <div class="loginBox"> <img class="user" src="https://i.ibb.co/yVGxFPR/2.png" height="100px" width="100px">
        <h3>Sign in here</h3>
        <form action="login" method="post">
            <div class="inputBox"> <input id="uname" type="text" name="username" placeholder="Username"> <input
                    id="pass" type="password" name="password" placeholder="Password"> </div> <input type="submit"
                name="" value="Login">
        </form>
        <a href="#">Forget Password<br> </a>
        <div class="text-center">
            <p style="color: #59238F;">Sign-Up</p>
        </div>

    </div>
    <!--Container Main end-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous">
    </script>

</body>

</html>