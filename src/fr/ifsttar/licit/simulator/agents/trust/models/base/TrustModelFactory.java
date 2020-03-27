package fr.ifsttar.licit.simulator.agents.trust.models.base;

import fr.ifsttar.licit.simulator.agents.trust.models.Fire;
import fr.ifsttar.licit.simulator.agents.trust.models.NoTrust;
import fr.ifsttar.licit.simulator.agents.trust.models.TrustNet;

public class TrustModelFactory {

	
    public static TrustModel create(TrustModelType trustModelType){

    	if(trustModelType==null)
    		return null;
    	
        TrustModel trustModel = null;
        if (trustModelType.isSetTrustModelNoTrust()) {
        	trustModel = new NoTrust(trustModelType.getTrustModelParameterNoTrust());
        } else if (trustModelType.isSetTrustModelTrustNet()) {
        	trustModel = new TrustNet(trustModelType.getTrustModelParameterTrustNet());
        } else if (trustModelType.isSetTrustModelFire()) {
        	trustModel = new Fire(trustModelType.getTrustModelFire());
        }  else {
            throw new IllegalArgumentException("unknown trust model=" + trustModelType.toString());
        }
        return trustModel;
    }

}
