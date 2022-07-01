import React from 'react';
import Recipe from './Recipe';
import SearchButton from '../components/SearchButton';
import { Box, VStack,Text  } from '@chakra-ui/react';
const Dessert = ({ recipes, getRecipe }) => {

	
	return (
		<VStack >
        <Box h="100px">
          <Text
            bgGradient="linear(to-l, #ca7928, #79ca28)"
            bgClip="text"
            fontSize="6xl"
            fontWeight="extrabold"
          >
            Desserts
          </Text>
        </Box>
        <SearchButton
          onClick={() => {
            getRecipe('dessert');
          }}
          searchBtn="Get Desserts Recipes"
        />
        <Recipe recipes={recipes} />
    </VStack>
	);
};

export default Dessert;