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
    //double hangPower = 0.2;
    //double intakeOpenPower = 0;
    //double launchPower = 0;

    public DcMotor leftfront;
    public DcMotor leftback;
    public DcMotor rightfront;
    public DcMotor rightback;

    public DcMotor arm; //lift arm

    public DcMotor extend; //extend arm

    public DcMotor lift1; //extending linear slides up
    public DcMotor lift2;

    public Servo brush; //intake brush

    //public DcMotor hang;

    //public DcMotor launch;

    /*public DcMotor intakeOpen; //moving intake arm

    public DcMotor outtake; //lift outtake to lander

    public DcMotor extend; //extend intake out from inside the robot

    public Servo latch; // to slide metal bar in/out of latch

    boolean setFullPosition = false; */


    @Override
    public void init() {
        leftfront = hardwareMap.dcMotor.get("leftfront");
        leftback = hardwareMap.dcMotor.get("leftback");
        rightfront = hardwareMap.dcMotor.get("rightfront");
        rightback = hardwareMap.dcMotor.get("rightback");
        rightback.setDirection(DcMotorSimple.Direction.REVERSE);
        rightfront.setDirection(DcMotorSimple.Direction.REVERSE);

        brush = hardwareMap.servo.get("brush");

        arm = hardwareMap.dcMotor.get("arm");

        extend = hardwareMap.dcMotor.get("extend");

        lift1 = hardwareMap.dcMotor.get("lift1");
        lift2 = hardwareMap.dcMotor.get("lift2");
        lift1.setDirection(DcMotorSimple.Direction.REVERSE);


        //hang = hardwareMap.dcMotor.get("hang");
        //hang.setDirection(DcMotorSimple.Direction.REVERSE);

        //launch = hardwareMap.dcMotor.get("launch");

        /*intakeOpen = hardwareMap.dcMotor.get("intakeOpen1");

        outtake = hardwareMap.dcMotor.get("outtake");

        extend = hardwareMap.dcMotor.get("extend");

        /*latch = hardwareMap.servo.get("latch");
        latch.setPosition(0);*/


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
            x = gamepad1.left_stick_x;
        } else {
            x = 0;
        }

        if (Math.abs(gamepad1.left_stick_y) > .2) {
            y = -gamepad1.left_stick_y;
        } else {
            y = 0;
        }

        if (Math.abs(gamepad1.right_stick_x) > .2) {
            z = -gamepad1.right_stick_x;
        } else {
            z = 0;
        }

        if (Math.abs(gamepad1.left_trigger) > 0.1) {    // extend the arm with intake
            extendPower = 1;

        } else if (Math.abs(gamepad1.right_trigger) > 0.1) { //
            extendPower = -1;

        } else {
            extendPower = 0;
        }

        //Gamepad 2 Controls

        if ((gamepad2.right_trigger) > 0.1) {                        // brush intake
            brush.setPosition(brush.getPosition()+0.1);

        } else if ((gamepad2.left_trigger) > 0.1) {
            brush.setPosition(brush.getPosition()-0.1);

        } else {
            brush.setPosition(0.5);
        }


        if (gamepad2.right_bumper) {             // lifing arm's chassis
            armPower = 1;

        } else if (gamepad2.left_bumper) {
            armPower = -1;

        } else {
            armPower = 0.3;
        }

        if (Math.abs(gamepad2.left_stick_y) > .1) {     //hanging from and lifting onto latch
            liftPower = gamepad2.left_stick_y;

        } else {
            liftPower = 0;
        }

        /*if (Math.abs(gamepad2.right_trigger) > .1) {    //launch Bob the marker
            launchPower = -1;

        } else if (Math.abs(gamepad2.left_trigger) > .1) {
            launchPower = 1;

        } else {
            launchPower = 0;
        } */


        /*if (gamepad2.right_bumper) {                  // opening intake arm
            intakeOpenPower = 1;

        } else if (gamepad2.left_bumper) {
            intakeOpenPower = -1;

        } else {
            intakeOpenPower = 0;
        } */


            /*intakeOpen.setTargetPosition(0);                // fully open
        }

        if (gamepad2.right_bumper) {                  // half open — transfer into outake position

            if (setFullPosition == true) {
                intakeOpen.setTargetPosition(1);

            } else {
                intakeOpen.setTargetPosition(2);
            }
        }*/

        /*if (gamepad2.right_trigger > 0.1) {             // lifing up the outake chassis
           outtakePower = 1;
           //hangPower = 1;

        } else if (gamepad2.left_trigger > 0.1) {
           outtakePower = -1;
           //hangPower = -1;

        } else {
           outtakePower = 0;
           //hangPower = 0;
        } */

        /* if (Math.abs(gamepad2.left_stick_y) > 0.1) {    // extend the arm with intake
            extendPower = gamepad2.left_stick_y;

        } else {
            extendPower = 0;
        } */




         leftback.setPower((x - y - z)*.75);                   // powers
         leftfront.setPower((-x - y - z)*.75);
         rightback.setPower((-x - y + z)*.75);
         rightfront.setPower((x - y + z)*.75);

         arm.setPower(armPower*0.35);
         extend.setPower(extendPower);
         lift1.setPower(liftPower);
         lift2.setPower(liftPower);
         brush.getPosition();
         //hang.setPower(hangPower);

         //launch.setPower(launchPower);
         //intakeOpen.setPower(intakeOpenPower*0.5);



        }

    }


