package ee.forgr.capacitor.shake;

import android.content.Context;
import android.hardware.SensorManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.squareup.seismic.ShakeDetector;

@CapacitorPlugin(name = "CapacitorShake")
public class CapacitorShakePlugin
  extends Plugin
  implements ShakeDetector.Listener {

  @Override
  public void load() {
    var shakeDetector = new ShakeDetector(this);
    var sensorManager = (SensorManager) this.bridge.getContext().getSystemService(Context.SENSOR_SERVICE);
    shakeDetector.start(sensorManager, SensorManager.SENSOR_DELAY_GAME);
    super.load();
  }

  @Override
  public void hearShake() {
    JSObject ret = new JSObject();
    notifyListeners("shake", ret);
  }
}
