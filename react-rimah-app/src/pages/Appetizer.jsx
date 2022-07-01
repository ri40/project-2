import React from 'react';
import Recipe from './Recipe';
import SearchButton from '../components/SearchButton';
import { Text, Box, VStack } from '@chakra-ui/react';
const Appetizer = ({ recipes, getRecipe }) => {
  return (
    <VStack>
        <Box h="100px">
          <Text
            bgGradient="linear(to-l, #ca7928, #79ca28)"
            bgClip="text"
            fontSize="6xl"
            fontWeight="extrabold"
          >
            Appetizers
          </Text>
        </Box>
        <SearchButton
          onClick={() => {
            getRecipe('appetizer');
          }}
          searchBtn="Get Appetizer Recipes"
        />
        <Recipe recipes={recipes} />
    </VStack>
  );
};

export default Appetizer;
