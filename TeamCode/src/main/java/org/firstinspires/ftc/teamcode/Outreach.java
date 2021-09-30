package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Outreachbot")
public class Outreach extends OpMode {
    DcMotor right;
    DcMotor left;
    Servo wings1;

    public Outreach() {
    }

    @Override
    public void init() {
        right = hardwareMap.dcMotor.get("right");
        left = hardwareMap.dcMotor.get("left");
        wings1 = hardwareMap.servo.get("wings");

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

        left.setPower(gamepad1LeftY);
        right.setPower(gamepad1RightY);

        //uses gamepad to control1 wing position
        if (gamepad1.a) {
            wings1.setPosition(.1);
        }
        //while robot is running, wings open
        else if (gamepad1LeftY != 0 && gamepad1RightY != 0) {
            wings1.setPosition(.1);
        } else {
            wings1.setPosition(.4);
        }
    }
}

