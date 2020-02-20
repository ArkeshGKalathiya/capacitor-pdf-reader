
  Pod::Spec.new do |s|
    s.name = 'NetgalaxyPdfReader'
    s.version = '0.0.1'
    s.summary = 'not yet'
    s.license = 'Apache v2'
    s.homepage = 'https://github.com/ArkeshGKalathiya/capacitor-pdf-reader'
    s.author = 'NetGalaxyStudios'
    s.source = { :git => 'https://github.com/ArkeshGKalathiya/capacitor-pdf-reader', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
  end