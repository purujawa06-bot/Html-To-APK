import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.purtv.donghua',
  appName: 'PurTV Donghua',
  webDir: 'src',
  server: {
    url: 'https://puruboy-api.vercel.app/page/purtv-donghua',
    cleartext: false,
    allowNavigation: [
      'puruboy-api.vercel.app',
      '*.vercel.app',
    ]
  },
  android: {
    allowMixedContent: false,
    captureInput: true,
    webContentsDebuggingEnabled: false,
    backgroundColor: '#0d0118',
    buildOptions: {
      keystorePath: 'purtv.keystore',
      keystoreAlias: 'purtv',
    }
  },
  plugins: {
    SplashScreen: {
      launchShowDuration: 2000,
      launchAutoHide: true,
      backgroundColor: '#0d0118',
      androidSplashResourceName: 'splash',
      showSpinner: false,
    },
    StatusBar: {
      style: 'DARK',
      backgroundColor: '#0d0118',
    },
  },
};

export default config;
