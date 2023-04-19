package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.BigBeakModel;

public class BigBeakSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void bigBeakIdleAnimation(BigBeakModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.5F, 100, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 2.5F, 100, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, 5F, 100, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.tail, 17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
	}
	
	public static void bigBeakWalkAnimation(BigBeakModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 500, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.5F, 250, tick, -0, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.5F, 250, tick, -0, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -1, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, -12.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.tail, 17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftWing, -5F, 500, tick, -floatMax, floatMax, -300, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightWing, -5F, 500, tick, -floatMax, floatMax, -300, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -3F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -25F, 250, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 5F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -0.25F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLegLower, 50F, 250, tick, -floatMax, 0, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFoot, -50F, 250, tick, -0, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFoot, 25F, 250, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFoot, 1F, 250, tick, -0, floatMax, 50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFrontToe, -60F, 250, tick, -0, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftBackToe, 60F, 250, tick, -floatMax, 0, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeftToe, -60F, 250, tick, -0, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftRightToe, 60F, 250, tick, -floatMax, 0, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 25F, 250, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -5F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 0.25F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLegLower, -50F, 250, tick, -floatMax, 0, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFoot, 50F, 250, tick, -0, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFoot, -25F, 250, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFoot, -1F, 250, tick, -0, floatMax, 50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFrontToe, 60F, 250, tick, -0, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightBackToe, -60F, 250, tick, -floatMax, 0, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeftToe, 60F, 250, tick, -0, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightRightToe, -60F, 250, tick, -floatMax, 0, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
	}
	
	public static void bigBeakJumpingAnimation(BigBeakModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.5F, 500, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -22.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, 2.5F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.tail, -27.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftWing, 1.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftWing, -25.7194F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftWing, -5.8669F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftWing, -20.3421F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightWing, 1.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightWing, -25.7194F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightWing, 5.8669F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightWing, 20.3421F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.5F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 15F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 1.5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, 27.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftFrontToe, 17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftBackToe, -60F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeftToe, 30F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftRightToe, -30F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1.5F, 500, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 35F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightFrontToe, 17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightBackToe, -60F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeftToe, 30F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightRightToe, -30F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
	}
	
	public static void bigBeakGlidingAnimation(BigBeakModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 250, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 12.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, 7.5F, 250, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.tail, 27.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftWing, -15.0F, 250, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftWing, -42.6088F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftWing, 3.6842F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftWing, -73.3826F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightWing, 15.0F, 250, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightWing, -42.6088F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightWing, -3.6842F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightWing, 73.3826F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -3F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -12.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -7.5F, 250, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, 52.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLegLower, 12.5F, 250, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLegLower, -105F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFoot, 7.5F, 250, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFoot, -12.5F, 250, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftFoot, 57.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFrontToe, 25F, 250, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftFrontToe, 40F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftBackToe, -25F, 250, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftBackToe, -30F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeftToe, 25F, 250, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeftToe, 30F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftRightToe, -25F, 250, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftRightToe, -30F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -5F, 250, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 35F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLegLower, 7.5F, 250, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLegLower, -75F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFoot, 7.5F, 250, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFoot, -5F, 250, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightFoot, 50F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFrontToe, 25F, 250, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightFrontToe, 40F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightBackToe, -25F, 250, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightBackToe, -30F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeftToe, 25F, 250, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeftToe, 30F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightRightToe, -25F, 250, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightRightToe, -30F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
	}
}
