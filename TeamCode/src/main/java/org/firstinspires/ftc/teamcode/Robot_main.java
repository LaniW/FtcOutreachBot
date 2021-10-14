package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Outreachbot")
public class Robot_main extends OpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor right;
    DcMotor left;

    public Robot_main() {
    }

    @Override
    public void init() {
        right = hardwareMap.dcMotor.get("right");
        left = hardwareMap.dcMotor.get("left");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");

        right.setDirection(DcMotorSimple.Direction.REVERSE);


        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        // left stick controls direction
        // right stick X controls rotation
        //front is neg, back is pos
        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1RightY = -gamepad1.right_stick_y;
        // above is ftc stuff, i should go look at it :)
        float[] array=PaulMath.omniCalc(gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
        left.setPower(gamepad1LeftY);
        right.setPower(gamepad1RightY);

        //uses gamepad to control1 wing position

    }
}

