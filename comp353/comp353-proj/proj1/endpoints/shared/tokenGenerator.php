<?php
    class Token{
        public static function generate() {
            $key = '';
            $keys = array_merge(range(0, 9), range('a', 'z'));
        
            for ($i = 0; $i < 50; $i++) {
                $key .= $keys[array_rand($keys)];
            }
        
            return $key;
        }
    }
?>