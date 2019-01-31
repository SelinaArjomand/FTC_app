package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by apple on 8/5/18.
 */

@TeleOp(name = "FTCRobot" , group = "Pushbot")

public class FTCRobot extends OpMode {

    double armPower = 0;
    double extendPower = 0;
    double liftPower = 0;

    public DcMotor leftfront;
    public DcMotor leftback;
    public DcMotor rightfront;
    public DcMotor rightback;

    public DcMotor arm; //lift arm

    public DcMotor extend; //extend arm

    public DcMotor lift1; //extending linear slides up
    public DcMotor lift2;

    public Servo brush; //intake brush
    public Servo outtake; //outtake's servo



    @Override
    public void init() {
        leftfront = hardwareMap.dcMotor.get("leftfront");
        leftback = hardwareMap.dcMotor.get("leftback");
        rightfront = hardwareMap.dcMotor.get("rightfront");
        rightback = hardwareMap.dcMotor.get("rightback");
        rightback.setDirection(DcMotorSimple.Direction.REVERSE);
        rightfront.setDirection(DcMotorSimple.Direction.REVERSE);

        arm = hardwareMap.dcMotor.get("arm");

        extend = hardwareMap.dcMotor.get("extend");

        lift1 = hardwareMap.dcMotor.get("lift1");
        lift2 = hardwareMap.dcMotor.get("lift2");
        lift1.setDirection(DcMotorSimple.Direction.REVERSE);


        brush = hardwareMap.servo.get("brush");
        outtake = hardwareMap.servo.get("outtake");


        telemetry.addData("Say", "Hello Driver");

    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
        float x;
        float y;
        float z;


        //Gamepad 1 Controls

        if (Math.abs(gamepad1.left_stick_x) > .2) {      // drive train
            x = -gamepad1.left_stick_x;
        } else {
            x = 0;
        }

        if (Math.abs(gamepad1.left_stick_y) > .2) {
            y = gamepad1.left_stick_y;
        } else {
            y = 0;
        }

        if (Math.abs(gamepad1.right_stick_x) > .2) {
            z = -gamepad1.right_stick_x;
        } else {
            z = 0;
        }

        if (Math.abs(gamepad1.left_trigger) > 0.1) {      // extend the arm with intake
            extendPower = 1;

        } else if (Math.abs(gamepad1.right_trigger) > 0.1) {
            extendPower = -1;

        } else {
            extendPower = 0;
        }

        if (gamepad1.a) {
            outtake.setPosition(1);
        }

        if (gamepad1.b) {
            outtake.setPosition(0);
        }

        //Gamepad 2 Controls

        if ((gamepad2.right_trigger) > 0.1) {                        // brush intake
            brush.setPosition(brush.getPosition()+0.1);

        } else if ((gamepad2.left_trigger) > 0.1) {
            brush.setPosition(brush.getPosition()-0.1);

        } else {
            brush.setPosition(0.5);
        }


        if (gamepad2.right_bumper) {             // lifing's chassis
            armPower = 1;

        } else if (gamepad2.left_bumper) {
            armPower = -1;

        } else {
            armPower = 0.3;
        }

        if (Math.abs(gamepad2.left_stick_y) > .1) {     //hanging from and lifting onto latch
            liftPower = -gamepad2.left_stick_y;

        } else {
            liftPower = 0;
        }



         leftback.setPower((x - y - z)*.75);                   // powers
         leftfront.setPower((-x - y - z)*.75);
         rightback.setPower((-x - y + z)*.75);
         rightfront.setPower((x - y + z)*.75);

         arm.setPower(armPower*0.50);
         extend.setPower(extendPower);
         lift1.setPower(liftPower);
         lift2.setPower(liftPower);
         brush.getPosition();


        }

    }


