# audiohack
Force Disable Auto Adjustment Audio Volume of Windows 8 or 8.1

Windows 8.1で音の出だしにフェードインしてしまう現象を力技で解決します。

## 原理
可聴域外の高周波音を鳴らし続けるだけです。  
スピーカーによってうなったりするようなので、周波数はいじれるようになっています。

## 使い方
bin/ にビルドしたものがあります。  
audiohack.jarをスタートアップに追加してください。  
デフォルトでは22KHzの音を鳴らしますが、audiohack.propでいじれます。

## 必要なもの
このソフトウェアはJavaで書かれているのでJavaをインストールしておいてください。  
[ここ](https://java.com/ja/download/)らへんからどうぞ。