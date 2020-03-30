var operations = ["square", "cube", "sin", "cos", "tan", "sqrt", "tenPower", "ln", "exp", "factorial","sinh", "cosh", "tanh", "log"];
// var digits = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];

function calculate(operation){
    var id = "#" + operation;
    var url = "/" + operation;

    $(id).on("click", function () {
        $.ajax({
            type: "GET",
            url: url,
            data: {
                "operand": $("#operand").val()
            },
            xhrFields: {withCredentials: true},
            success: function (data) {
                if (data.status === "success") {
                    $("#operand").val(data.data);
                } else {
                    alert("Error!" + data.data.errMsg);
                }
            },
            error: function (data) {
                alert("Error, reason:" + data.responseText);
            }
        });
    });
}

jQuery(document).ready(function () {

    for (var i = 0; i < operations.length; i++) {
        calculate(operations[i]);
    }

    $("#equal").on("click", function () {
        $.ajax({
            type: "GET",
            url: "/equal",
            data: {
                "expression": $("#operand").val()
            },
            xhrFields: {withCredentials: true},
            success: function (data) {
                if (data.status === "success") {
                    $("#operand").val(data.data);
                } else {
                    alert("Error!" + data.data.errMsg);
                }
            },
            error: function (data) {
                alert("Error, reason:" + data.responseText);
            }
        });
    });

    $(".clear").on("click", function () {
        $("#operand").val("");
    });

    $("#zero").on("click", function () {
        $("#operand").val($("#operand").val() + "0");
    });

    $("#one").on("click", function () {
        $("#operand").val($("#operand").val() + "1");
    });

    $("#two").on("click", function () {
        $("#operand").val($("#operand").val() + "2");
    });

    $("#three").on("click", function () {
        $("#operand").val($("#operand").val() + "3");
    });

    $("#four").on("click", function () {
        $("#operand").val($("#operand").val() + "4");
    });

    $("#five").on("click", function () {
        $("#operand").val($("#operand").val() + "5");
    });

    $("#six").on("click", function () {
        $("#operand").val($("#operand").val() + "6");
    });

    $("#seven").on("click", function () {
        $("#operand").val($("#operand").val() + "7");
    });

    $("#eight").on("click", function () {
        $("#operand").val($("#operand").val() + "8");
    });

    $("#nine").on("click", function () {
        $("#operand").val($("#operand").val() + "9");
    });

    $("#addition").on("click", function () {
        $("#operand").val($("#operand").val() + "+");
    });

    $("#subtraction").on("click", function () {
        $("#operand").val($("#operand").val() + "-");
    });

    $("#multiplication").on("click", function () {
        $("#operand").val($("#operand").val() + "*");
    });

    $("#division").on("click", function () {
        $("#operand").val($("#operand").val() + "/");
    });

    $("#dot").on("click", function () {
        var operand = $("#operand").val();
        if (operand === ""){
            $("#operand").val("0.");
        } else if(operand.indexOf(".") < 0){
            $("#operand").val($("#operand").val() + ".");
        }
    });

    $("#left").on("click", function () {
        $("#operand").val($("#operand").val() + "(");
    });

    $("#right").on("click", function () {
        $("#operand").val($("#operand").val() + ")");
    });

    $("#negation").on("click", function () {
        var expression = $("#operand").val();
        if (expression.startsWith("-")) {
            $("#operand").val(expression.substring(1));
        } else {
            $("#operand").val("-" + expression);
        }
    });

    $("#pi").on("click", function () {
        $("#operand").val("3.14159265358979323846");
    });
});