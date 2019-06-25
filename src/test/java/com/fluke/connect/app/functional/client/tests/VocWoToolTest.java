package com.fluke.connect.app.functional.client.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fluke.connect.app.testdata.SignIn;
import com.fluke.connect.app.testdata.SignIn.FeatureList;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;

public class VocWoToolTest {
	@BeforeClass(groups = { Config.VOC_WO })

	public void initClass() throws Exception {
		if (!DriverManager.isSmokeSuite()) {
			DriverManager.getSignIn().signIn(SignIn.getUID(FeatureList.WORKORDERS),
					SignIn.getPWD(FeatureList.WORKORDERS));
			DriverManager.getSignIn().handleAfterSignInAlertsOtherUser();
		}
	}

	@Test(priority = 37400, groups = { Config.VOC_WO })
	public void testcase1() {
		Assert.fail();
	}

	@Test(priority = 37401, groups = { Config.VOC_WO })
	public void testcase2() {
		Assert.fail();
	}

	@Test(priority = 37402, groups = { Config.VOC_WO })
	public void testcase3() {
		Assert.fail();
	}
	@Test(priority = 37403, groups = { Config.VOC_WO })
	public void testcase4() {
		Assert.fail();
	}

	@Test(priority = 37404, groups = { Config.VOC_WO })
	public void testcase5() {
		Assert.fail();
	}

	@Test(priority = 37405, groups = { Config.VOC_WO })
	public void testcase6() {
		Assert.fail();
	}

	@Test(priority = 37406, groups = { Config.VOC_WO })
	public void testcase7() {
		Assert.fail();
	}

	@Test(priority = 37407, groups = { Config.VOC_WO })
	public void testcase8() {
		Assert.fail();
	}

	@Test(priority = 37408, groups = { Config.VOC_WO })
	public void testcase9() {
		Assert.fail();
	}

	@Test(priority = 37409, groups = { Config.VOC_WO })
	public void testcase10() {
		Assert.fail();
	}

	@Test(priority = 37410, groups = { Config.VOC_WO })
	public void testcase11() {
		Assert.fail();
	}

	@Test(priority = 37411, groups = { Config.VOC_WO })
	public void testcase12() {
		Assert.fail();
	}

	@Test(priority = 37412, groups = { Config.VOC_WO })
	public void testcase13() {
		Assert.fail();
	}

	@Test(priority = 37413, groups = { Config.VOC_WO })
	public void testcase14() {
		Assert.fail();
	}

	@Test(priority = 37414, groups = { Config.VOC_WO })
	public void testcase15() {
		Assert.fail();
	}

	@Test(priority = 37415, groups = { Config.VOC_WO })
	public void testcase16() {
		Assert.fail();
	}
	@Test(priority = 37416, groups = { Config.VOC_WO })
	public void testcase17() {
		Assert.fail();
	}

	@Test(priority = 37417, groups = { Config.VOC_WO })
	public void testcase18() {
		Assert.fail();
	}

	@Test(priority = 37418, groups = { Config.VOC_WO })
	public void testcase19() {
		Assert.fail();
	}

	@Test(priority = 37419, groups = { Config.VOC_WO })
	public void testcase20() {
		Assert.fail();
	}

	@Test(priority = 37420, groups = { Config.VOC_WO })
	public void testcase21() {
		Assert.fail();
	}

	@Test(priority = 37421, groups = { Config.VOC_WO })
	public void testcase22() {
		Assert.fail();
	}

	@Test(priority = 37422, groups = { Config.VOC_WO })
	public void testcase23() {
		Assert.fail();
	}

	@Test(priority = 37423, groups = { Config.VOC_WO })
	public void testcase24() {
		Assert.fail();
	}

	@Test(priority = 37424, groups = { Config.VOC_WO })
	public void testcase25() {
		Assert.fail();
	}

	@Test(priority = 37425, groups = { Config.VOC_WO })
	public void testcase26() {
		Assert.fail();
	}

	@Test(priority = 37426, groups = { Config.VOC_WO })
	public void testcase27() {
		Assert.fail();
	}

	@Test(priority = 37427, groups = { Config.VOC_WO })
	public void testcase28() {
		Assert.fail();
	}

	@Test(priority = 37428, groups = { Config.VOC_WO })
	public void testcase29() {
		Assert.fail();
	}

	@Test(priority = 37429, groups = { Config.VOC_WO })
	public void testcase30() {
		Assert.fail();
	}

	@Test(priority = 37430, groups = { Config.VOC_WO })
	public void testcase31() {
		Assert.fail();
	}
}
