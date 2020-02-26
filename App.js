// /**
//  * Sample React Native App
//  * https://github.com/facebook/react-native
//  *
//  * @format
//  * @flow
//  */

import React, {Component} from 'react';
import {
  StyleSheet,
  Text,
  DeviceEventEmitter,
  NativeModules,
  View,
} from 'react-native';

export default class AwesomeProject extends Component {
  componentWillMount() {
    //監聽事件名為EventName的事件
    DeviceEventEmitter.addListener('EventName', function() {
      alert('send success!!');
    });
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome} onPress={this.callNative.bind(this)}>
          當你點我時，會調用原生方法，原生方法延遲3秒後會向前端發送事件。
          前端一直在監聽該事件，如果收到，則給出alert提示!
        </Text>
      </View>
    );
  }

  callNative() {
    NativeModules.MyModule.NativeMethod();
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
