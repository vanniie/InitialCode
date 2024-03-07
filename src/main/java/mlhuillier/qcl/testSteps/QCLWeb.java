package mlhuillier.qcl.testSteps;

import mlhuillier.qcl.testSteps.testExecution.TestExecutionUtils;

import static mlhuillier.qcl.utilities.ExtentReporter.HeaderChildNode;
import static mlhuillier.qcl.utilities.Utilities.*;

public class QCLWeb extends BaseClass{

    public void  toValidateTheLoginFunctionality() throws Exception{
        HeaderChildNode("To Validate the login functionality");
        TestExecutionUtils.signInQCLWeb();
        extentLoggerPass("", "To Validate the login functionality validated");
    }

}
