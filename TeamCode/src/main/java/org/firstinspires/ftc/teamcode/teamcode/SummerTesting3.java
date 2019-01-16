package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by apple on 7/27/18.
 */

@TeleOp(name="SummerTesting3" , group="PushBot")

public class SummerTesting3 extends OpMode {

    public DcMotor leftfront; //declaring motors
    public DcMotor leftback;
    public DcMotor rightfront;
    public DcMotor rightback;


    @Override
    public void init() {
        leftback = hardwareMap.dcMotor.get("leftback"); //initilizing names of motors
        leftfront = hardwareMap.dcMotor.get("leftfront");
        rightback = hardwareMap.dcMotor.get("rightback");
        rightfront = hardwareMap.dcMotor.get("rightfront");
    }

    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        leftback.setPower(gamepad1.left_stick_y);
        leftfront.setPower(gamepad1.left_stick_y);
        rightback.setPower(-gamepad1.right_stick_y);
        rightfront.setPower(-gamepad1.right_stick_y);
    }

    @Override
    public void stop() {
    }
}