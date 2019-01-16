package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by apple on 8/5/18.
 */

@TeleOp(name = "STCRobot" , group = "Pushbot")

public class STCRobot extends OpMode {

    public DcMotor leftfront;
    public DcMotor leftback;
    public DcMotor rightfront;
    public DcMotor rightback;
    double leftSideDrive;
    double rightSideDrive;
    double intakePower = 0;
    double relicExtend = 0;

    public DcMotor intake;

    public DcMotor relic;

    public Servo release;

    @Override
    public void init() {
        leftfront = hardwareMap.dcMotor.get("leftfront");
        leftback = hardwareMap.dcMotor.get("leftback");
        rightfront = hardwareMap.dcMotor.get("rightfront");
        rightback = hardwareMap.dcMotor.get("rightback");

        intake = hardwareMap.dcMotor.get("intake");

        relic = hardwareMap.dcMotor.get("relic");

        release = hardwareMap.servo.get("release");


    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {


        if (Math.abs(gamepad1.left_stick_y)> 0.1)
            leftSideDrive = -gamepad1.left_stick_y;
        else
            leftSideDrive = 0;

        if(Math.abs(gamepad1.right_stick_y)> 0.1)
            rightSideDrive = gamepad1.right_stick_y;
        else
            rightSideDrive = 0;


        if(gamepad1.left_bumper) {
            intakePower = 1;
        }
        else if(gamepad1.right_bumper)
            intakePower = -1;
        else
            intakePower = 0;

        if (gamepad1.a) {
            release.setPosition(0);
        }

        else if (gamepad1.b) {
            release.setPosition(1);
        }

        if (Math.abs(gamepad2.right_stick_y)> 0.2)
            relicExtend = gamepad2.right_stick_y;
        else {
            relicExtend = 0;
        }



        leftfront.setPower(leftSideDrive*0.5);
        leftback.setPower(leftSideDrive*0.5);
        rightfront.setPower(rightSideDrive*0.5);
        rightback.setPower(rightSideDrive*0.5);
        intake.setPower(intakePower);
        relic.setPower(relicExtend);

    }

}
