import {
  Box,
  useColorModeValue,
  Heading,
  Text,
  Stack,
  Image,
  useDisclosure,
  Link,
} from '@chakra-ui/react';

export default function RecipeCard({ title, image, prepTime, sourceUrl }) {
  return (
    <>
      <Box
        role={'group'}
        p={6}
        maxW={'330px'}
        w={'full'}
        bg={useColorModeValue('white', 'gray.800')}
        boxShadow={'2xl'}
        rounded={'lg'}
        pos={'relative'}
        zIndex={1}
        mt={10}
      >
        <Box
          rounded={'md'}
          mt={-12}
          pos={'relative'}
          height={'230px'}
          _after={{
            transition: 'all .3s ease',
            content: '""',
            w: 'full',
            h: 'full',
            pos: 'absolute',
            top: 5,
            left: 0,
            //   backgroundImage: url(${IMAGE}),
            filter: 'blur(15px)',
            zIndex: -1,
          }}
          _groupHover={{
            _after: {
              filter: 'blur(20px)',
            },
          }}
        >
          <Image
            rounded={'lg'}
            height={230}
            width={282}
            objectFit={'cover'}
            src={image}
          />
        </Box>
        <Stack pt={10} align={'center'}>
          <Text color={'gray.500'} fontSize={'2xl'} textTransform={'uppercase'}>
            <Link href={sourceUrl}>{title}</Link>
          </Text>
          <Heading
            color={'gray.500'}
            fontSize={'sm'}
            fontFamily={'body'}
            fontWeight={500}
          >
            Ready In Minutes: {prepTime}
          </Heading>
        </Stack>
      </Box>
    </>
  );
}
