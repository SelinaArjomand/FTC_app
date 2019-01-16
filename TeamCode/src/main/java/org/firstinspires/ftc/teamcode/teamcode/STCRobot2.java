package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by apple on 8/26/18.
 */
@TeleOp(name = "STCRobot2" , group = "Pushbot")

public class STCRobot2 extends OpMode{


    public DcMotor leftfront;
    public DcMotor leftback;
    public DcMotor rightfront;
    public DcMotor rightback;

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
        double leftSideDrive = 0;
        double rightSideDrive = 0;
        double intakePower = 0;
        double relicExtend = 0;


        if (Math.abs(gamepad1.right_stick_y)> 0.1)
            leftSideDrive = gamepad1.left_stick_y;

        if(Math.abs(gamepad1.left_stick_y)> 0.1)
            rightSideDrive = -gamepad1.right_stick_y;

        if(Math.abs(gamepad2.left_trigger)> 0.1)
            intakePower = gamepad1.left_trigger;

        if(Math.abs(gamepad2.right_trigger)> 0.1)
            intakePower = -gamepad1.right_trigger;

        if (gamepad1.a) {
            release.setPosition(0);
        }

        else if (gamepad1.b) {
            release.setPosition(1);
        }

        if (Math.abs(gamepad2.right_stick_y)> 0.1)
            relicExtend = gamepad2.left_stick_y;

        if(Math.abs(gamepad2.left_stick_y)> 0.1)
            relicExtend = -gamepad2.right_stick_y;


        leftfront.setPower(leftSideDrive);
        leftback.setPower(leftSideDrive);
        rightfront.setPower(rightSideDrive);
        rightback.setPower(rightSideDrive);
        intake.setPower(intakePower);
        relic.setPower(relicExtend);

    }

}
