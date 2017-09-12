Flex layout is used:
$ npm install @angular/flex-layout -save

Usage:
1. npm install
2. npm install @angular/flex-layout -save

Troubleshooting scenario:
1. npm uninstall -g @angular/cli
2. npm cache clean
3. npm install -g @angular/cli@latest
Local project package:
4. rm -rf node_modules dist # use rmdir /S/Q node_modules dist in Windows Command Prompt;
   use rm -r -fo node_modules,dist in Windows PowerShell
5. npm install --save-dev @angular/cli@latest
6. npm install
7. npm install @angular/flex-layout -save