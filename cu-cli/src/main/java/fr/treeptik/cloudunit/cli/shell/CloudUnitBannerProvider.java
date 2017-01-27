package fr.treeptik.cloudunit.cli.shell;

import com.github.lalyos.jfiglet.FigletFont;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.plugin.BannerProvider;
import org.springframework.stereotype.Component;

/**
 * Created by guillaume on 15/10/15.
 */
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CloudUnitBannerProvider implements BannerProvider, CommandMarker {
    private static final String BANNER = "CloudUnit CLI";

    private static final String WELCOME_MESSAGE =
            "CloudUnit CLI %s - Create, deploy and manage your JAVA application into the Cloud";

    @Value("${cloudunit.cli.version}")
    private String cliVersion;
    
    @Value("${cloudunit.cli.quiet:false}")
    private boolean quiet;

    @Override
    public String getBanner() {
        return unlessQuiet(FigletFont.convertOneLine(BANNER));
    }

    @Override
    public String getVersion() {
        return cliVersion;
    }

    @Override
    public String getWelcomeMessage() {
        return unlessQuiet(String.format(WELCOME_MESSAGE, cliVersion));
    }

    @Override
    public String getProviderName() {
        return "cloudunit-cli";
    }
    
    private String unlessQuiet(String s) {
        return quiet ? "" : s;
    }
}
