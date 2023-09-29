package Order;

import Models.Country;
import Models.Player;

public class Deploy implements IOrders{
    private int numberOfArmiesToDeploy;
    private String targetCountryName ;
    private String targetCountryID ;

    public Deploy(int _numberOfArmiesToDeploy,String _targetCountryID, String _targetCountryName) {
        this.numberOfArmiesToDeploy = _numberOfArmiesToDeploy;
        this.targetCountryName = _targetCountryName;
        this.targetCountryID = _targetCountryID;
    }
    @Override
    public void execute(Player player) {
        while (!player.getD_orderList().isEmpty()) {
            for(Country country: player.getD_coutriesOwned()) {
                if(country.getName().equals(targetCountryName)) {
                    country.setD_Armies(country.getD_Armies()+numberOfArmiesToDeploy);
                    player.getD_orderList().poll();
                    break;
                }
            }
        }
    }

    @Override
    public boolean valid(int p_gameState) {
        return false;
    }

    @Override
    public void printOrder() {

    }

    @Override
    public String getOrderName() {
        return null;
    }
}
