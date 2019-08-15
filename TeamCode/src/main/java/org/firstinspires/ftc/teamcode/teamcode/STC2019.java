package org.firstinspires.ftc.teamcode.teamcode.vision;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by apple on 8/5/18.
 */

@TeleOp(name = "STC2019" , group = "Pushbot")

public class STC2019 extends OpMode {

    double liftPower = 0;

    public DcMotor leftfront;
    public DcMotor leftback;
    public DcMotor rightfront;
    public DcMotor rightback;

    public DcMotor lift;

    public Servo arm1; //right?
    public Servo arm2; //left?

    @Override
    public void init() {
        leftfront = hardwareMap.dcMotor.get("leftfront");
        leftback = hardwareMap.dcMotor.get("leftback");
        rightfront = hardwareMap.dcMotor.get("rightfront");
        rightback = hardwareMap.dcMotor.get("rightback");
        rightfront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightback.setDirection(DcMotorSimple.Direction.REVERSE);

        lift = hardwareMap.dcMotor.get("lift");

        arm1 = hardwareMap.servo.get("arm1");
        arm2 = hardwareMap.servo.get("arm2");

        arm2.setDirection(Servo.Direction.REVERSE);


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


        //Gamepad 2 Controls

        if (Math.abs(gamepad2.left_stick_y) > .2) {      //  linear slide lift
            liftPower = gamepad2.right_stick_y;
        } else {
            liftPower = 0;
        }

        if (gamepad2.a) {                               // arms
            arm1.setPosition(1);
            arm2.setPosition(1);
        }

        if (gamepad2.b) {
            arm1.setPosition(0);
            arm2.setPosition(0);
        }




        leftback.setPower((x - y - z)*.75);                   // powers
        leftfront.setPower((-x - y - z)*.75);
        rightback.setPower((-x - y + z)*.75);
        rightfront.setPower((x - y + z)*.75);

        lift.setPower(liftPower);

    }

}
