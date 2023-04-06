package com.infamous.infamous_legends.animation.keyframe_animations.definition;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BigFungusThrowerKeyframeAnimations {

	public static final AnimationDefinition BIG_FUNGUS_THROWER_NOVELTY = AnimationDefinition.Builder.withLength(1.375f)
	.addAnimation("body",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(12.395952257471436f, -2.9799139163710606f, 1.902474694431021f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(9.895029055208306f, -0.0017618087463051602f, -0.00509982085222882f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.125f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5416766f, KeyframeAnimations.posVec(1f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.125f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(-22.897694647887874f, 11.943364609305263f, -3.7092101734092466f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.875f, KeyframeAnimations.degreeVec(-15.972045047115351f, 19.107175807004694f, -5.913735272551512f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftEar",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(7.5f, 0f, 15f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(12.180421903387014f, 4.478370949171222f, -1.868252308213414f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.2916767f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightEar",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(38.968716463313285f, -13.124786053872413f, 25.001352265230707f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(50.67469015883873f, -9.977024256363274f, 28.96960598376836f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(-32.84807224722324f, -13.5641157991822f, 0.522542972303853f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.25f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("noseFoliage",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 37.5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(0.4082810458347197f, -3.6234529457091957f, -11.960018497760483f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(0.4082810458347197f, -3.6234529457091957f, -11.960018497760483f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.375f, KeyframeAnimations.posVec(-2f, 2f, -4f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5f, KeyframeAnimations.posVec(-2.89f, 1f, -3.33f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75f, KeyframeAnimations.posVec(-4f, 2f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(-14.7416f, 2.6885493872482247f, 9.6065f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.375f, KeyframeAnimations.degreeVec(-89.61696276056159f, -47.30933424271012f, 9.31625366690092f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(-89.67605919745085f, -37.31018653725965f, 9.402962899070026f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(-14.7416f, 2.6885493872482247f, 9.6065f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(-14.7416f, 2.6885493872482247f, 9.6065f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("bodyOverlayLower",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-14.757427357250705f, 3.513695977964019f, 0.5437838083491078f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(-8.392135026934302f, -0.299068961744527f, -1.4660407449267425f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM))).build();
	
	public static final AnimationDefinition BIG_FUNGUS_THROWER_THROW = AnimationDefinition.Builder.withLength(4f)
	.addAnimation("body",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 1f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 2f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.625f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, 4f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 4f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.2916767f, KeyframeAnimations.posVec(0f, -1f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0.5f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.7916765f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.9167665f, KeyframeAnimations.posVec(0f, 1f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(3.1676665f, KeyframeAnimations.posVec(0f, 2f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(3.375f, KeyframeAnimations.posVec(0f, -1f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(3.625f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("body",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(19.903587702291134f, -3.2026975860430866f, 1.4970288971776426f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.375f, KeyframeAnimations.degreeVec(19.903587702291134f, -3.2026975860430866f, 1.4970288971776426f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.625f, KeyframeAnimations.degreeVec(19.903587702291134f, -3.2026975860430866f, 1.4970288971776426f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(11.147167747875208f, -19.605812334494384f, -4.73769932226196f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(7.463874408009268f, -21.227648207615584f, 5.793646721663208f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.4583433f, KeyframeAnimations.degreeVec(15.460957749252175f, -2.5754250839068487f, 1.6008942179884613f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(15.829783248126624f, 8.789291251527557f, 7.380996222842532f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.875f, KeyframeAnimations.degreeVec(15.739195047898612f, 6.3835330879063985f, 6.694992053294845f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.125f, KeyframeAnimations.degreeVec(18.133270268114465f, 6.489324646881851f, 6.728596520670653f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.4583435f, KeyframeAnimations.degreeVec(15.709362871838167f, 8.717853549426273f, 7.247847696975549f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(18.028819172399345f, 11.611827891519825f, 5.324768631082861f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.9167665f, KeyframeAnimations.degreeVec(2.482394539903016f, 7.274757146923566f, 2.638656039925863f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.1676665f, KeyframeAnimations.degreeVec(-2.517605460096984f, 7.274757146923566f, 2.638656039925863f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.4583435f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.7916765f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.375f, KeyframeAnimations.degreeVec(-10.013190994959132f, 5.7914881039077954f, 4.056010962591699f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(-10.013190994959132f, 5.7914881039077954f, 4.056010962591699f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(-10.298122977372493f, 7.644666990933764f, 12.980028407261724f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(-9.268558987995494f, 17.494939841188298f, 0.12815105822890516f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.4167667f, KeyframeAnimations.degreeVec(-9.268558987995494f, 17.494939841188298f, 0.12815105822890516f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.7916767f, KeyframeAnimations.degreeVec(-11.154969990864192f, 49.39721006167905f, -7.51246476819153f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.1676665f, KeyframeAnimations.degreeVec(-12.54739057611996f, 43.99357465016228f, -9.577797443901781f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.4583435f, KeyframeAnimations.degreeVec(-4.590451534162913f, 39.344827337844656f, -4.969826245747827f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(-0.2721940716413336f, 42.05169204382341f, 1.4788128664575018f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.375f, KeyframeAnimations.degreeVec(-30f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.625f, KeyframeAnimations.degreeVec(-6.883505195537637f, 0.2998151336664705f, 2.481968395896729f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.875f, KeyframeAnimations.degreeVec(-14.98636590938986f, -0.6468560589119079f, -2.414917191767927f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftEar",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.25f, KeyframeAnimations.degreeVec(-15f, 0f, 5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(5f, 0f, 5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.875f, KeyframeAnimations.degreeVec(-27.298870708189497f, 3.455327220816798f, 11.660672540854193f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(-14.8f, 3.46f, 11.66f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(19.995613702701757f, -2.396749615853005f, -10.074813511487118f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.625f, KeyframeAnimations.degreeVec(16.01978967055902f, -5.082752321674798f, 12.319896338370363f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.125f, KeyframeAnimations.degreeVec(-18.98f, -5.08f, 12.32f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.5f, KeyframeAnimations.degreeVec(13.52f, -5.08f, 12.32f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(-6.48f, -5.08f, 12.32f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3f, KeyframeAnimations.degreeVec(-5.256290313363007f, -8.223222327377771f, -37.94933840327274f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.25f, KeyframeAnimations.degreeVec(0.0172182800194971f, -9.74912899685407f, -70.82969699597761f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.4583435f, KeyframeAnimations.degreeVec(-9.715300520294914f, 0.826065707424732f, 24.101500823143326f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.75f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightEar",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(-17.31593525613198f, -2.1539316219250395f, -14.767579743670012f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(21.46120123659437f, -7.8143486150414905f, -0.8218542924210119f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.25f, KeyframeAnimations.degreeVec(-20.701022038978444f, -8.700770126601181f, -3.1804085736446903f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.625f, KeyframeAnimations.degreeVec(-34.7903816662526f, -11.406530624990591f, 10.882348784491406f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.875f, KeyframeAnimations.degreeVec(-19.466258946053166f, -21.553936380237847f, 18.510206882331552f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.1676665f, KeyframeAnimations.degreeVec(-16.554488888234317f, -12.323345684409833f, 23.95415707577264f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.625f, KeyframeAnimations.degreeVec(-10.877127377435773f, -9.311675200563805f, 33.66089970070489f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(6.971277364221459f, -9.574235524850847f, 15.895221767874006f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3f, KeyframeAnimations.degreeVec(-4.759974526066599f, 10.973626631913412f, 39.77737357664764f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.25f, KeyframeAnimations.degreeVec(1.4401445571195293f, 11.860713707813575f, 70.38694230031095f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.4583435f, KeyframeAnimations.degreeVec(-11.945048992832254f, -0.13995313479166782f, -27.244937564756f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.75f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("noseFoliage",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.375f, KeyframeAnimations.degreeVec(-12.5f, 0f, -10f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.4717833073355f, -0.6518169913756537f, -14.957438388617902f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(-6.80177766690369f, 3.1628898389936695f, 14.809560096109216f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.3433333f, KeyframeAnimations.degreeVec(-44.23327840780648f, -3.8971765543345462f, 4.485972116291633f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.5416767f, KeyframeAnimations.degreeVec(-0.47531819536605013f, -4.239429335950172f, -13.051312896254112f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(-15.48f, -4.24f, -13.05f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.875f, KeyframeAnimations.degreeVec(-0.4800000000000004f, -4.24f, -13.05f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.1676665f, KeyframeAnimations.degreeVec(-0.8483520331451291f, -4.182003901930093f, -8.036793870102247f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.5f, KeyframeAnimations.degreeVec(-0.29615765813250616f, -4.2551227559298965f, -15.560017812134937f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.8343335f, KeyframeAnimations.degreeVec(-1.2164568732398948f, -4.093920614158614f, -3.027678311458713f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.125f, KeyframeAnimations.degreeVec(-26.22f, -4.09f, -3.03f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.375f, KeyframeAnimations.degreeVec(-58.72f, -4.09f, -3.03f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.625f, KeyframeAnimations.degreeVec(-8.719999999999999f, -4.09f, -3.03f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.8343335f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -2f, 3f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.375f, KeyframeAnimations.posVec(0f, -2f, 3f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -2f, 3f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -2f, 5f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.125f, KeyframeAnimations.posVec(0f, -2f, 5f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.625f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.875f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.25f, KeyframeAnimations.degreeVec(-43.83374283623032f, 0.9697602818069209f, -21.21779931628789f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.375f, KeyframeAnimations.degreeVec(-43.83374283623032f, 0.9697602818069209f, -21.21779931628789f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(-43.83f, 0.97f, -21.22f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(43.67f, 0.97f, -21.22f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.125f, KeyframeAnimations.degreeVec(43.67f, 0.97f, -21.22f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.625f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.875f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.25f, KeyframeAnimations.degreeVec(-26.647890846895443f, -1.8112180541938514f, -15.873787320138216f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.6766665f, KeyframeAnimations.degreeVec(-6.615423249397189f, -12.31672067028836f, -19.693306505500566f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.8343335f, KeyframeAnimations.degreeVec(-6.615423249397189f, -12.31672067028836f, -19.693306505500566f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.9583435f, KeyframeAnimations.degreeVec(-40.62287309302894f, -23.309874402282567f, 7.325462889804893f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.2083435f, KeyframeAnimations.degreeVec(-45.62287309302894f, -23.309874402282567f, 7.325462889804893f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.5f, KeyframeAnimations.degreeVec(10.17915546504273f, -0.8286932837640961f, -9.623197423937128f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.7916765f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4f, KeyframeAnimations.degreeVec(-14.9299f, -1.7081840554196788f, -4.6999f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 2f, 3f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 2f, 3f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 2f, -1f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 2f, -1f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.625f, KeyframeAnimations.posVec(-1f, -1f, -1f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.875f, KeyframeAnimations.posVec(0f, -1f, 1f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.25f, KeyframeAnimations.posVec(0f, -1f, -2f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.5834335f, KeyframeAnimations.posVec(0f, -0.07000000000000006f, -0.7699999999999996f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.8343335f, KeyframeAnimations.posVec(0f, -0.65f, -2.7199999999999998f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.9167665f, KeyframeAnimations.posVec(0f, -0.65f, 3.2800000000000002f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(3.2083435f, KeyframeAnimations.posVec(0f, -0.65f, 3.2800000000000002f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(3.625f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(-14.7416f, 2.6885493872482247f, 9.6065f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.25f, KeyframeAnimations.degreeVec(64.34097517127543f, 17.607593709049013f, 29.373245329851542f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(64.34097517127543f, 17.607593709049013f, 29.373245329851542f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.75f, KeyframeAnimations.degreeVec(-169.1435088110135f, 13.787805001548676f, 4.161338360460942f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.25f, KeyframeAnimations.degreeVec(-169.1435088110135f, 13.787805001548676f, 4.161338360460942f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.625f, KeyframeAnimations.degreeVec(64.61961188575832f, 3.7251692513246972f, -8.910561868336881f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.875f, KeyframeAnimations.degreeVec(57.0107308494684f, 2.5362114613915034f, -16.630838305749275f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.25f, KeyframeAnimations.degreeVec(63.03684425274052f, 9.372157327235726f, -8.87340726018314f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.5834335f, KeyframeAnimations.degreeVec(56.81958233152282f, 14.968868708139144f, -13.399503686080152f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.8343335f, KeyframeAnimations.degreeVec(65.84f, 13f, -15.06f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.9167665f, KeyframeAnimations.degreeVec(66.49501232530733f, -0.7339547210171986f, -8.978688106317405f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.2083435f, KeyframeAnimations.degreeVec(66.49501232530733f, -0.7339547210171986f, -8.978688106317405f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.625f, KeyframeAnimations.degreeVec(-14.7416f, 2.6885493872482247f, 9.6065f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4f, KeyframeAnimations.degreeVec(-14.7416f, 2.6885493872482247f, 9.6065f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("fungus",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5f, KeyframeAnimations.posVec(-2f, 0f, -2f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, -6f, 4f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.7916765f, KeyframeAnimations.posVec(0f, -6f, 4f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.8343335f, KeyframeAnimations.posVec(6f, 0f, 1f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(2.9167665f, KeyframeAnimations.posVec(1f, 0f, 1f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(3.4167665f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("fungus",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.5f, KeyframeAnimations.degreeVec(-31.063877702607897f, 11.888383666197115f, 21.93729685722201f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(72.45678380722902f, 29.450471427978066f, -8.788656808542346f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(72.46f, 29.45f, -8.79f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.8343335f, KeyframeAnimations.degreeVec(122.25742035364328f, 5.73852923080949f, -4.837107366425698f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.9167665f, KeyframeAnimations.degreeVec(122.25742035364328f, 5.73852923080949f, -4.837107366425698f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.4167665f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("fungus",
		new AnimationChannel(AnimationChannel.Targets.SCALE,
			new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
				AnimationChannel.Interpolations.LINEAR),
			new Keyframe(0.7083434f, KeyframeAnimations.scaleVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR),
			new Keyframe(2.7916765f, KeyframeAnimations.scaleVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.LINEAR),
			new Keyframe(2.8343335f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
				AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("rightLeg",
		new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.625f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.7916766f, KeyframeAnimations.posVec(1f, 4f, -3f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.2083433f, KeyframeAnimations.posVec(1f, 4f, -3f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.375f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightLeg",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(27.298870708189497f, -3.455327220816798f, 6.660672540853739f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(27.298870708189497f, -3.455327220816798f, 6.660672540853739f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("bodyOverlayLowerRight",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.875f, KeyframeAnimations.degreeVec(22.283104441117757f, 5.857893430729746f, 4.644762041761169f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(31.730371332132563f, 7.732516038098311f, -0.023541120266600046f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(21.73f, 7.73f, -0.02f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("bodyOverlayLower",
		new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(0.625f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1f, KeyframeAnimations.degreeVec(-2.521544676601934f, 7.4928206685040095f, -0.3290232005838334f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.375f, KeyframeAnimations.degreeVec(-19.925481272378892f, 5.140317620727037f, 0.5290858668662803f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(1.7083433f, KeyframeAnimations.degreeVec(-9.977867163411865f, -7.222418116767003f, 2.3638863215512904f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.125f, KeyframeAnimations.degreeVec(-16.93827638153378f, -11.08729021132487f, -1.7275250638837316f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.5834335f, KeyframeAnimations.degreeVec(-15.826399512632126f, -4.610091136287192f, -6.276367467405162f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(2.75f, KeyframeAnimations.degreeVec(-15.826399512632126f, -4.610091136287192f, -6.276367467405162f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3f, KeyframeAnimations.degreeVec(8.628825812465875f, 2.2557925447973863f, -3.3308996570783895f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.2916765f, KeyframeAnimations.degreeVec(-8.863105140845272f, -0.21013434492510008f, -2.944634132212814f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.625f, KeyframeAnimations.degreeVec(-11.142262319622532f, 4.616129780369229f, -0.11881585002760398f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(3.8343335f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM),
			new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
				AnimationChannel.Interpolations.CATMULLROM))).build();
}